(* Module de la passe de génération de code *)

open Tds
open Exceptions
open Ast
open Type
open Tam
open Code


type t1 = AstPlacement.programme
type t2 = string

(* convert_affectable_to_type : AstPlacement.affectable -> AstType.affectable *)
let rec convert_affectable_to_type = function
  | AstPlacement.Ident info -> AstType.Ident info
  | AstPlacement.Deref a -> AstType.Deref (convert_affectable_to_type a)

  (*  Obtenir le type d'un affectable *)
let rec get_type_affectable a =
  match a with
  | AstType.Ident info ->
      begin
        match info_ast_to_info info with
        | InfoVar (_, t, _, _,_) -> t
        | InfoConst (_, _) -> Int
        | _ -> failwith "Erreur: pas une variable"
      end
  
  | AstType.Deref a' ->
      let t = get_type_affectable a' in
      begin
        match t with
        | Pointeur t_pointe -> t_pointe
        | _ -> failwith "Erreur: déréférencement d'un non-pointeur"
      end


(* analyse_code_affectable_lecture : AstType.affectable -> string *)
(* Génère le code TAM pour mettre la VALEUR de l'affectable sur le sommet de la pile. *)
(* Cas complexes gérés : *)
(* 1. Référence (est_ref=true) : La variable contient une adresse. *)
(* -> On charge cette adresse (LOAD 1) puis on va chercher la valeur pointée (LOADI). *)
(* 2. Déréférencement ( *p) : *)
(* -> On calcule l'adresse de p, puis on charge la valeur pointée (LOADI). *)
(* 3. Enum : *)
(* -> On charge directement la valeur entière constante (LOADL). *)
let rec analyse_code_affectable_lecture a =
  match a with
  | AstType.Ident info ->
      begin
        match info_ast_to_info info with
        | InfoVar (_, t, dep, reg, est_ref) ->
               if est_ref then
      (* Référence : on charge l'adresse (1 mot) puis la valeur pointée *)
                load 1 dep reg ^ loadi (getTaille t)
               else
                (* Variable normale *)
                let taille = getTaille t in
                load taille dep reg
   
        | InfoConst (_, va) ->
            loadl_int va       
        | InfoEnumConst (_, val_enum, _) ->
            loadl_int val_enum
        | _ -> failwith "Erreur: pas une variable"
      end
  
  | AstType.Deref a' ->
      (* 1. Calculer l'adresse du pointeur *)
      let code_adr = analyse_code_affectable_lecture a' in
      let t_pointe = get_type_affectable a in
      let taille = getTaille t_pointe in
      
      (* 2. Charger la valeur à cette adresse *)
      code_adr ^ loadi taille (* loadi charge depuis l'adresse au sommet *)

(*  code pour affectable en écriture *)
(* analyse_code_affectable_ecriture : AstType.affectable -> string *)
(* Génère le code TAM pour ÉCRIRE la valeur (au sommet de la pile) dans l'affectable. *)
(* Cas complexes gérés : *)
(* 1. Référence (est_ref=true) : On doit écrire à l'adresse indiquée par la variable. *)
(* -> LOAD 1 (adresse) + STOREI (écriture indirecte). *)
(* 2. Variable simple : Écriture directe dans la pile (STORE). *)
let analyse_code_affectable_ecriture a =
  match a with
  | AstType.Ident info ->
      begin
        match info_ast_to_info info with
        | InfoVar (_, t, dep, reg, est_ref) ->
          if est_ref then
      (* Référence : on charge l'adresse puis on stocke la valeur à cette adresse *)
            load 1 dep reg ^ storei (getTaille t)
            
          else    (* Variable normale *)
              let taille = getTaille t in
              store taille dep reg
        | _ -> failwith "Erreur: pas une variable"
      end
  
  | AstType.Deref a' ->
      (* 1. Calculer l'adresse du pointeur *)
      let code_adr = analyse_code_affectable_lecture a' in
      let t_pointe = get_type_affectable a in
      let taille = getTaille t_pointe in
      (* 2. Stocker à cette adresse *)
      code_adr ^ storei taille

let rec analyse_code_expression e =
  match e with

      | AstType.AppelFonction (info, le) ->
        let cle = List.fold_right (fun e acc -> (analyse_code_expression e)^acc) le "" in 

        begin match info_ast_to_info info with
            | InfoFun(nom_fun, _, _,_) -> cle^(call "SB" nom_fun)
            | _ -> raise (MauvaiseUtilisationIdentifiant ("identifier pas de fonction "))
        end 

    | AstType.Booleen (b) -> if b then (loadl_int 1) else (loadl_int 0)

    | AstType.Entier (i) -> loadl_int i

    | AstType.Unaire(op, e1) -> 
        if (op = AstType.Numerateur) then (analyse_code_expression e1)^(pop 0 1)
        else (analyse_code_expression e1)^(pop 1 1)

    | AstType.Binaire (op, e1,e2) -> 
        let codeExp1 = analyse_code_expression e1 in
        let codeExp2 = analyse_code_expression e2 in 
        begin match op with
          | AstType.PlusInt -> codeExp1^codeExp2^(subr "IAdd")
          | AstType.PlusRat -> codeExp1^codeExp2^(call "SB" "RAdd")
          | AstType.MultInt -> codeExp1^codeExp2^(subr "IMul")
          | AstType.MultRat -> codeExp1^codeExp2^(call "SB" "RMul")
          | AstType.EquInt -> codeExp1^codeExp2^(subr "IEq")
          | AstType.EquBool -> codeExp1^codeExp2^(subr "IEq")
          | AstType.Inf -> codeExp1^codeExp2^(subr "ILss")
          | AstType.Fraction -> codeExp1^codeExp2^(call "SB" "norm")
        end
    | AstType.Null -> loadl_int 0
  
  (*  New - allocation mémoire *)
    | AstType.New t ->
      let taille = getTaille t in
      loadl_int taille ^ subr "MAlloc"
  
  (*  Adresse *)
    | AstType.Adresse info ->
      begin
        match info_ast_to_info info with
        | InfoVar (_, _, dep, reg, _) ->
            loada dep reg
        | _ -> failwith "Erreur: pas une variable"
      end

  (*  Affectable *)
   | AstType.Affectable a ->
      analyse_code_affectable_lecture a
   | AstType.Ref info ->
    begin match info_ast_to_info info with
      | InfoVar(_, _, dep, reg, is_ref) ->
       if is_ref then     
        load 1 dep reg
       else
        loada dep reg
      | _ -> failwith "Erreur interne"
    end

(* analyse_code_instruction : AstPlacement.instruction -> string *)
(* Génère le code pour les structures de contrôle et les affectations. *)
(* Utilise des étiquettes (Labels) pour les sauts (JUMP/JUMPIF). *)   
let rec analyse_code_instruction i = 
  match i with
    | AstPlacement.Declaration(info,e) ->
        begin
          match info_ast_to_info info with
          | InfoVar(_,t,dep,reg,_) ->
              let taille = getTaille t in
              let codeExp = analyse_code_expression e in
              (push taille)^codeExp^(store taille dep reg)
          | _ -> failwith "Erreur: déclaration d'une constante ou fonction"
        end
    | AstPlacement.Affectation(info,e) ->
        let codeExp = analyse_code_expression e in
        let codeAffect = analyse_code_affectable_ecriture (convert_affectable_to_type info) in
        codeExp ^ codeAffect
    | AstPlacement.AffichageInt e ->

        let codeExp = analyse_code_expression e in
        codeExp^(subr "IOut") 

    | AstPlacement.AffichageRat e ->

        let codeExp = analyse_code_expression e in
        codeExp^(call "SB" "rout")
    | AstPlacement.AffichageBool e ->

        let codeExp = analyse_code_expression e in
        codeExp^(subr "BOut")

    | AstPlacement.Conditionnelle (c,bt,be) ->

        let codeExp = analyse_code_expression c in
        let eti_be = getEtiquette() in 
        let end_if = getEtiquette() in
        codeExp ^
        jumpif 0 eti_be ^ 
        analyse_code_bloc bt ^ 
        jump end_if ^
        label eti_be ^
        analyse_code_bloc be ^
        label end_if 
    
    | AstPlacement.TantQue (c, b) -> 

        let codeExp = analyse_code_expression c in 
        let debut = getEtiquette() in 
        let fin_tq = getEtiquette() in
        label debut ^
        codeExp ^
        jumpif 0 fin_tq ^
        analyse_code_bloc b ^ 
        jump debut ^
        label fin_tq

    | AstPlacement.Retour(e,tr,tp) ->
        (analyse_code_expression e)^(return tr tp)
    
    | AstPlacement.Empty -> ""

    | AstPlacement.AppelProcedure (info, le) ->
    let cle = List.fold_right (fun e acc -> (analyse_code_expression e) ^ acc) le "" in
    begin
      match info_ast_to_info info with
      | InfoFun(nom_fun, _, _,_) -> cle ^ call "SB" nom_fun
      | _ -> failwith "Pas une fonction"
    end

    | AstPlacement.RetourVoid ->
    return 0 0  (* Return sans valeur *)

and analyse_code_bloc (li, _) =
  List.fold_right
    (fun i str -> analyse_code_instruction i ^ str)
    li
    ""


let analyse_code_fonction (AstPlacement.Fonction (info , _, ( li , _))) = 
    (* Pour verifier que si une fonction continet retour*)
    let rec analyse_instruction_retour li =
        (match li with 
            |[] -> false
            |a :: q ->( match a with 
                        | AstPlacement.Retour(_,_,_) -> true
                        | _ -> analyse_instruction_retour q )
        )
    in
    let nom = 
    match info_ast_to_info info with 
        | InfoFun(nom , _, _, _) -> nom
        | _ -> failwith "error"
    in 
    
    (* Sécurité : si pas de return explicite (cas void ou oubli), on ajoute HALT ou RETURN implicite *)
    (* Note : Pour une procédure correcte, cela devrait être un RETURN 0 0 si on veut être propre, *)
    (* mais HALT permet de stopper proprement le MAIN. *)
    let queue = if (analyse_instruction_retour li) then "" else  halt in 
    label nom ^
    (List.fold_right (fun i str -> (analyse_code_instruction i)^str ) li "")^
    queue

let analyser (AstPlacement.Programme (fonctions, prog)) = 
    getEntete() ^  
    (List.fold_right (fun i str -> (analyse_code_fonction i)^str ) fonctions "") ^
    label "main" ^
    analyse_code_bloc prog ^ 
    halt