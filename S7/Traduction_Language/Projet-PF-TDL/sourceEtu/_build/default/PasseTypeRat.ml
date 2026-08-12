(* Module de la passe de typage *)
(* doit être conforme à l'interface Passe *)
open Tds
open Exceptions
open Ast
open Type

type t1 = Ast.AstTds.programme
type t2 = Ast.AstType.programme


(* analyse_type_affectable : AstTds.affectable -> AstType.affectable * typ *)
(* Paramètre a : l'affectable à analyser (issu de la TDS) *)
(* Vérifie et retourne le type de l'affectable. *)
(* - Identifiant : récupère le type stocké dans la TDS (Variable, Constante ou Enum). *)
(* - Déréférencement ( * p) : vérifie que l'expression est bien un pointeur et retourne le type pointé. *)

let rec analyse_type_affectable a =
  match a with
  | AstTds.Ident info ->
      let t = match info_ast_to_info info with
        | InfoVar (_, typ, _, _,_) -> typ
        | InfoConst (_, _) -> Int
        | InfoEnumConst (_, _, nom_type) -> Enum nom_type
        | _ -> raise (MauvaiseUtilisationIdentifiant "Pas une variable")
      in
      (AstType.Ident info, t)
  
  | AstTds.Deref a' ->
      let (na, t) = analyse_type_affectable a' in
      begin
        match t with
        | Pointeur t_pointe ->
            (AstType.Deref na, t_pointe)
        | _ ->
            raise (TypeInattendu (t, Pointeur Undefined))
      end

(* analyse_type_expression : AstTds.expression -> AstType.expression * type *)
(* Paramètre e : l'expression à analyser *)
(* Vérifie la compatibilité des types pour toutes les opérations (binaires, unaires, appels). *)
(* Retourne l'expression typée et son type. *)

let rec analyse_type_expression e = 

  let type_of_unaire op =
  match op with
  | AstSyntax.Numerateur -> AstType.Numerateur
  | AstSyntax.Denominateur -> AstType.Denominateur
  in 

  match e with
    |AstTds.AppelFonction (info, le) -> 
          let nv_le = List.map analyse_type_expression le in
          let l_typ = List.map (fun (_,  t)-> t) nv_le in
          let l_exps = List.map (fun (e, _)-> e) nv_le in

          begin match info_ast_to_info info with
            | InfoFun(_, t, ln, lr) -> 
              if (not (est_compatible_list l_typ ln)) then 
                    raise (TypesParametresInattendus(l_typ, ln));
              let l_ref_appel = List.map (fun e ->
                match e with
                | AstTds.Ref _ -> true
                | _ -> false
                ) le in
        
              if l_ref_appel <> lr then
                 raise PassageRefIncoherent;
        
              (AstType.AppelFonction(info, l_exps), t)
             
            | _ -> raise (MauvaiseUtilisationIdentifiant ("identifier pas de fonction "))
                                  end 

    |AstTds.Unaire(op, e1) -> 

          let (ne, t) = analyse_type_expression e1 in
          if (est_compatible t Rat ) then 
              (AstType.Unaire(type_of_unaire op, ne), Int)
          else 
              raise (TypeInattendu (t ,Rat) )
    |AstTds.Binaire(op, e1,e2) ->
          let (ne1, t1) = analyse_type_expression e1 in
          let (ne2, t2)= analyse_type_expression e2 in 
          let erreur () = raise (TypeBinaireInattendu(op,t1,t2)) in
          begin match op with
            | AstSyntax.Plus -> begin
                match (t1,t2) with
                | Int, Int -> (AstType.Binaire(PlusInt, ne1, ne2),Int)
                | Rat, Rat -> (AstType.Binaire(PlusRat, ne1, ne2),Rat)
                | _ -> erreur ()
              end
            | AstSyntax.Mult -> begin
                match (t1,t2) with
                | Int, Int -> (AstType.Binaire(MultInt, ne1, ne2),Int)
                | Rat, Rat -> (AstType.Binaire(MultRat, ne1, ne2),Rat)
                | _ -> erreur ()
              end
            | AstSyntax.Equ -> begin
                match (t1,t2) with
                | Int, Int -> (AstType.Binaire(EquInt, ne1, ne2),Bool)
                | Bool, Bool -> (AstType.Binaire(EquBool, ne1, ne2),Bool)
                | Enum n1, Enum n2 when n1 = n2 -> (AstType.Binaire(EquInt, ne1, ne2), Bool)
                | _ -> erreur ()
              end
            | AstSyntax.Fraction -> begin
                match (t1,t2) with
                | Int, Int -> (AstType.Binaire(Fraction, ne1, ne2),Rat)
                | _ -> erreur ()
              end
            | AstSyntax.Inf -> begin
                match (t1,t2) with
                | Int, Int -> (AstType.Binaire(Inf, ne1, ne2),Bool)
                | _ -> erreur ()
              end
          end
    |AstTds.Booleen b -> (AstType.Booleen(b), Bool)
    |AstTds.Entier i -> (AstType.Entier(i), Int)
    | AstTds.Null -> (AstType.Null, Pointeur Undefined)
  
  
    | AstTds.New t -> (AstType.New t, Pointeur t)
  
  
    | AstTds.Adresse info ->
      begin
        match info_ast_to_info info with
        | InfoVar (_, t, _, _,_) ->
            (AstType.Adresse info, Pointeur t)
        | _ ->
            raise (MauvaiseUtilisationIdentifiant "Pas une variable")
      end
  
  
  | AstTds.Affectable a ->
      let (na, t) = analyse_type_affectable a in
      (AstType.Affectable na, t)
  | AstTds.Ref info ->
      (* Pour l'instant, ref retourne le type de la variable *)
      begin match info_ast_to_info info with
      | InfoVar(_, t, _, _,_) -> (AstType.Ref info, t)
      | _ -> failwith "Erreur interne"
      end

(* analyse_type_instruction : AstTds.instruction -> AstType.instruction *)
(* Patamétte i : instriction *)
(* erreurs si types non compatible *)
let rec analyse_type_instruction i =
  begin match i with 

    | AstTds.Declaration(t,info, e) ->
        let (ne , nt) = analyse_type_expression e in 
          if (est_compatible nt t) then begin
            modifier_type_variable t info  ;
            AstType.Declaration(info, ne)
          end
          else
            raise (TypeInattendu(nt, t)) 

    | AstTds.Affectation (a, e) ->
      let (na, t_aff) = analyse_type_affectable a in
      let (ne, t_exp) = analyse_type_expression e in
      if est_compatible t_exp t_aff then
        AstType.Affectation (na, ne)
      else
        raise (TypeInattendu (t_exp, t_aff))

    | AstTds.Affichage e ->
      let (ne, typ) = analyse_type_expression e in
      begin
        match typ with
        | Int -> AstType.AffichageInt ne
        | Bool -> AstType.AffichageBool ne
        | Rat -> AstType.AffichageRat ne
        | Pointeur _ ->
            (* Les pointeurs s'affichent comme des entiers (adresses) *)
            AstType.AffichageInt ne
        | Enum _ -> AstType.AffichageInt ne
        | Void -> raise (TypeInattendu (Void, Int)) 
        | _ -> raise (TypeInattendu (Undefined, Int))
      end
    
    | AstTds.Conditionnelle(c,t,e) -> 
        let (nc, typ) = analyse_type_expression c in 
        let nt = analyse_type_bloc t in 
        let ne = analyse_type_bloc e in
        if (est_compatible typ Bool) then AstType.Conditionnelle(nc ,nt, ne)
        else raise (TypeInattendu(typ, Bool))

    | AstTds.TantQue (c,b) -> 
        let (nc , typ) = analyse_type_expression c in 
        let nb = analyse_type_bloc b in 
        if (est_compatible typ Bool) then AstType.TantQue(nc ,nb)
        else raise (TypeInattendu(typ, Bool))

    | AstTds.Retour(e , ia) -> 
        let (ne, t) = analyse_type_expression e in 
        begin match info_ast_to_info ia with
          |InfoFun(_,ty,_,_) -> if (est_compatible t ty) then AstType.Retour(ne, ia)
                              else raise (TypeInattendu(t, ty))
          | _ -> raise (MauvaiseUtilisationIdentifiant "Not Func")
          end
    | AstTds.Empty -> AstType.Empty

    | AstTds.AppelProcedure (info, le) ->
       let nv_le = List.map analyse_type_expression le in
       let l_typ = List.map (fun (_, t) -> t) nv_le in
       let l_exps = List.map (fun (e, _) -> e) nv_le in
      begin
       match info_ast_to_info info with
       | InfoFun(_, Void, ln, lr) ->  (*  Vérifier que c'est bien void *)
          if not (est_compatible_list l_typ ln) then
            raise (TypesParametresInattendus(l_typ, ln));

          let l_ref_appel = List.map (fun e ->
            match e with
            | AstTds.Ref _ -> true
            | _ -> false
          ) le in
          
          if l_ref_appel <> lr then
            raise PassageRefIncoherent;
          
          AstType.AppelProcedure(info, l_exps)
          
       | InfoFun(_, _, _, _) ->
          raise (MauvaiseUtilisationIdentifiant "Fonction utilisée comme procédure")
       | _ ->
          raise (MauvaiseUtilisationIdentifiant "Pas une fonction")
     end

    | AstTds.RetourVoid info -> 
     begin
      match info_ast_to_info info with
      | InfoFun(_, Void, _, _) ->
          AstType.RetourVoid info
      | InfoFun(_, t, _, _) ->
          raise (TypeInattendu(Void, t))
      | _ -> failwith "Erreur interne"
     end
    end 

and analyse_type_bloc li = 
  List.map (fun i -> analyse_type_instruction i) li 

  
(* analyse_type_fonction : AstTds.fonction -> AstType.fonction  *)
(* erreurs si types non compatible *)
let analyse_type_fonction (AstTds.Fonction(t,info,lp,li)) =
 
  let l_typ = List.map (fun (t, _, _) -> t) lp in
  let l_ref = List.map (fun (_, _, r) -> r) lp in
  let l_info =  List.map (fun (_,i, r) -> (i,r)) lp in 
  modifier_type_fonction t l_typ l_ref info;
  let nli = analyse_type_bloc li in
  match info_ast_to_info info with 
    |InfoFun(_,_,lt,lr) ->
      if (est_compatible_list lt l_typ) && (lr = l_ref)then
          AstType.Fonction(info,l_info,nli)
      else
        raise (TypesParametresInattendus(l_typ, lt))   
    | _ -> raise (MauvaiseUtilisationIdentifiant("error"))      

(* analyse_type_fonctions : AstTds.fonction list -> AstType.fonction list *)
(* Patamétte lf : liste des fonctions *)
(* erreurs si types non compatible *)
let analyse_type_fonctions lf =
  List.map analyse_type_fonction lf
      

(* analyse : AstTds.Programme -> AstType.Programme  *)
(* Patamétte fonctions : fonctions en programmes *)
(** Paramtre prog : bloc principale *)
(* erreurs si types non compatible *)
let analyser (AstTds.Programme(fonctions, prog)) =
   
   let preparer_fonction (AstTds.Fonction(t,info,lp,_)) =
    let l_typ = List.map (fun (t,_,_) -> t) lp in
    let l_ref = List.map (fun (_,_,r) -> r) lp in
    modifier_type_fonction t l_typ l_ref info
    in
  List.iter preparer_fonction fonctions;
  let p = analyse_type_bloc(prog) in 
  let lf = analyse_type_fonctions fonctions in 
  AstType.Programme(lf, p)

    
