(* Module de la passe de placement memoire *)
(* doit être conforme à l'interface Passe *)
open Tds
open Ast
open Type


type t1 = AstType.programme
type t2 = AstPlacement.programme

(* Fonction pour placer les paramètres *)
(* place_params : (type * info_ast * bool) list -> int -> unit *)
(* Paramètres : liste des paramètres (type, info, est_ref), déplacement courant *)
(* Rôle : Attribue les adresses aux paramètres d'une fonction. *)
(* Logique : *)
(* - Les paramètres sont empilés "sous" LB, donc les déplacements sont négatifs. *)
(* - Si est_ref = true, la taille est forcée à 1 (adresse). *)
(* - Sinon, on utilise getTaille(t). *)
let rec place_params params depl =
  match params with
    | [] -> ()
    | (t, p, _isRef) :: q ->   
        let taille = if _isRef then 1 else getTaille t in
        let adresse = depl - taille in
        modifier_adresse_variable adresse "LB" p;
        place_params q adresse
let rec convert_affectable = function
  | AstType.Ident info -> AstPlacement.Ident info
  | AstType.Deref a -> AstPlacement.Deref (convert_affectable a)

let rec analyse_placement_instruction i depl reg = 
  match i with
    | AstType.Declaration (info,e) ->
        begin
            match (info_ast_to_info info ) with
              | InfoVar(_,t,_,_,_) -> 
                  modifier_adresse_variable depl reg info ;
                  (AstPlacement.Declaration(info,e), getTaille(t))
              | _ -> failwith "Error "
        end
    | AstType.Conditionnelle (c, t , e) ->
      let bt = analyse_placement_bloc t depl reg in
      let be = analyse_placement_bloc e depl reg in
      (AstPlacement.Conditionnelle (c, bt, be), 0)

    | AstType.TantQue(c,b) ->
        let nb = analyse_placement_bloc b depl reg in 
        (AstPlacement.TantQue(c,nb), 0)

    | AstType.Retour(e, ia) ->
      begin
        match (info_ast_to_info ia) with
          | InfoFun(_, tr, tp, _) -> 
              (AstPlacement.Retour(e, getTaille tr ,
               (List.fold_right (fun t tq -> tq + getTaille t) tp 0 )
              ),0)
          | _ -> failwith "Error "
      end

    | AstType.Affectation(a , e) -> (AstPlacement.Affectation(convert_affectable a, e),0)

    | AstType.AffichageInt (e) -> (AstPlacement.AffichageInt(e),0)

    | AstType.AffichageRat (e) -> (AstPlacement.AffichageRat(e),0)

    | AstType.AffichageBool (e) -> (AstPlacement.AffichageBool(e),0)

    | AstType.Empty -> (AstPlacement.Empty,0)
    | AstType.AppelProcedure (info, le) -> (AstPlacement.AppelProcedure (info, le),0)
    | AstType.RetourVoid _ -> (AstPlacement.RetourVoid, 0)
                             



and analyse_placement_bloc li depl reg =
 match li with 
    | [] -> ([],0)
    | i :: q -> let (ni , ti) = analyse_placement_instruction i depl reg in
                let (nq, tq) = analyse_placement_bloc q (depl + ti) reg in 
                (ni :: nq, ti + tq)

and analyse_placement_fonction (AstType.Fonction(info, lp, li)) =
  let typed_params = List.map (fun (p,est_ref) ->  
  let t = match info_ast_to_info p with 
    | InfoVar(_,typ,_,_,_) -> typ
    | _ -> failwith "Error"
  in
  (t, p,est_ref)
  ) lp in

   let reversed_params = List.rev typed_params in  
   place_params reversed_params 0; 
  
  let nv_li = analyse_placement_bloc li 3 "LB" in
  AstPlacement.Fonction(info, lp, nv_li)


let analyser (AstType.Programme (fonctions, prog)) =
   let nv_fonctions = List.map analyse_placement_fonction fonctions in 
   let nv_prog = analyse_placement_bloc prog 0 "SB" in 
   AstPlacement.Programme(nv_fonctions, nv_prog)

