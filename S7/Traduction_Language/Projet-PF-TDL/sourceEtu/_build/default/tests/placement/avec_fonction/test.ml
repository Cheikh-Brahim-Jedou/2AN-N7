open Rat
open Compilateur
open Passe

(* Return la liste des adresses des variables d'un programme RAT *)
let getListeDep ratfile =
  let input = open_in ratfile in
  let filebuf = Lexing.from_channel input in
  try
    let ast = Parser.main Lexer.token filebuf in
    let past = CompilateurRat.calculer_placement ast in
    let listeAdresses = VerifPlacement.analyser past in
    listeAdresses
  with
  | Lexer.Error _ as e ->
      report_error ratfile filebuf "lexical error (unexpected character).";
      raise e
  | Parser.Error as e->
      report_error ratfile filebuf "syntax error.";
      raise e

(* teste si dans le fichier fichier, dans la fonction fonction (main pour programme principal)
la occ occurence de la variable var a l'adresse dep[registre]
*)
let test fichier fonction (var,occ) (dep,registre) = 
  let l = getListeDep fichier in
  let lmain = List.assoc fonction l in
  let rec aux i lmain = 
    if i=1 
    then
      let (d,r) = List.assoc var lmain in
      (d=dep && r=registre)
    else 
      aux (i-1) (List.remove_assoc var lmain)
  in aux occ lmain

(****************************************)
(** Chemin d'accès aux fichiers de test *)
(****************************************)

let pathFichiersRat = "../../../../../tests/placement/avec_fonction/fichiersRat/"


let%test "test8_x_1" = 
   test (pathFichiersRat^"test8.rat")  "main" ("x",1)  (0, "SB")
|| test (pathFichiersRat^"test8.rat")  "main" ("x",1)  (0, "LB")
    
let%test "test8_y_1" = 
   test (pathFichiersRat^"test8.rat")  "main" ("y",1)  (1, "SB")
|| test (pathFichiersRat^"test8.rat")  "main" ("y",1)  (1, "LB")
    
let%test "test8_z_1" = 
   test (pathFichiersRat^"test8.rat")  "main" ("z",1)  (3, "SB")
|| test (pathFichiersRat^"test8.rat")  "main" ("z",1)  (3, "LB")
  
let%test "test8_x_2" = 
   test (pathFichiersRat^"test8.rat")  "main" ("x",2)  (4, "SB")
|| test (pathFichiersRat^"test8.rat")  "main" ("x",2)  (4, "LB")
    
let%test "test8_y_2" = 
   test (pathFichiersRat^"test8.rat")  "main" ("y",2)  (5, "SB")
|| test (pathFichiersRat^"test8.rat")  "main" ("y",2)  (5, "LB")
    
let%test "test8_z_2" = 
   test (pathFichiersRat^"test8.rat")  "main" ("z",2)  (7, "SB")
|| test (pathFichiersRat^"test8.rat")  "main" ("z",2)  (7, "LB")
  
let%test "test8_x1" = 
   test (pathFichiersRat^"test8.rat")  "main" ("x1",1)  (4, "SB")
|| test (pathFichiersRat^"test8.rat")  "main" ("x1",1)  (4, "LB")
    
let%test "test8_y1" = 
   test (pathFichiersRat^"test8.rat")  "main" ("y1",1)  (5, "SB")
|| test (pathFichiersRat^"test8.rat")  "main" ("y1",1)  (5, "LB")
    
let%test "test8_z1" = 
   test (pathFichiersRat^"test8.rat" ) "main" ("z1",1)  (7, "SB")
|| test (pathFichiersRat^"test8.rat" ) "main" ("z1",1)  (7, "LB")

let%test "test8_f_x_1" = 
  test (pathFichiersRat^"test8.rat")  "f" ("x",1)  (3, "LB")
    
let%test "test8_f_y_1" = 
  test (pathFichiersRat^"test8.rat")  "f" ("y",1)  (4, "LB")
    
let%test "test8_f_z_1" = 
  test (pathFichiersRat^"test8.rat")  "f" ("z",1)  (6, "LB")
  
let%test "test8_f_x_2" = 
  test (pathFichiersRat^"test8.rat")  "f" ("x",2)  (7, "LB")
    
let%test "test8_f_y_2" = 
  test (pathFichiersRat^"test8.rat")  "f" ("y",2)  (8, "LB")
    
let%test "test8_f_z_2" = 
  test (pathFichiersRat^"test8.rat")  "f" ("z",2)  (10, "LB")
  
let%test "test8_f_x1" = 
  test (pathFichiersRat^"test8.rat")  "f" ("x1",1)  (7, "LB")
    
let%test "test8_f_y1" = 
  test (pathFichiersRat^"test8.rat")  "f" ("y1",1)  (8, "LB")
    
let%test "test8_f_z1" = 
  test (pathFichiersRat^"test8.rat")  "f" ("z1",1)  (10, "LB")
    
let%test "test8_f_a" = 
  test (pathFichiersRat^"test8.rat")  "f" ("a",1)  (-1, "LB")
    
let%test "test9_f_a" = 
  test (pathFichiersRat^"test9.rat")  "f" ("a",1)  (-1, "LB")

let%test "test10_f_a" = 
  test (pathFichiersRat^"test10.rat")  "f" ("a",1)  (-2, "LB")

let%test "test11_f_a" = 
  test (pathFichiersRat^"test11.rat")  "f" ("a",1)  (-1, "LB")
    
let%test "test12_f_b" = 
  test (pathFichiersRat^"test12.rat")  "f" ("b",1)  (-4, "LB")
    
let%test "test12_f_r" = 
  test (pathFichiersRat^"test12.rat")  "f" ("r",1)  (-3, "LB")
    
let%test "test12_f_i" = 
  test (pathFichiersRat^"test12.rat")  "f" ("i",1)  (-1, "LB")


(* Tests de placement pour les pointeurs - AVEC FONCTION *)


let%test "testPlacementPointeurLocale_f_x" = 
  test (pathFichiersRat^"testPlacementPointeurLocale.rat") "f" ("x",1) (-1, "LB")

let%test "testPlacementPointeurLocale_f_p" = 
  test (pathFichiersRat^"testPlacementPointeurLocale.rat") "f" ("p",1) (3, "LB")

let%test "testPlacementPointeurLocale_f_y" = 
  test (pathFichiersRat^"testPlacementPointeurLocale.rat") "f" ("y",1) (4, "LB")


let%test "testPlacementPointeurParam_f_p" = 
  test (pathFichiersRat^"testPlacementPointeurParam.rat") "f" ("p",1) (-1, "LB")

let%test "testPlacementPointeurParam_main_x" = 
  test (pathFichiersRat^"testPlacementPointeurParam.rat") "main" ("x",1) (0, "LB")
|| test (pathFichiersRat^"testPlacementPointeurParam.rat") "main" ("x",1) (0, "SB")


let%test "testPlacementPointeurParamMultiple_f_a" = 
  test (pathFichiersRat^"testPlacementPointeurParamMultiple.rat") "somme" ("a",1) (-2, "LB")

let%test "testPlacementPointeurParamMultiple_f_b" = 
  test (pathFichiersRat^"testPlacementPointeurParamMultiple.rat") "somme" ("b",1) (-1, "LB")

let%test "testPlacementPointeurParamMultiple_main_x" = 
  test (pathFichiersRat^"testPlacementPointeurParamMultiple.rat") "main" ("x",1) (0, "LB")
|| test (pathFichiersRat^"testPlacementPointeurParamMultiple.rat") "main" ("x",1) (0, "SB")

let%test "testPlacementPointeurParamMultiple_main_y" = 
  test (pathFichiersRat^"testPlacementPointeurParamMultiple.rat") "main" ("y",1) (1, "LB")
|| test (pathFichiersRat^"testPlacementPointeurParamMultiple.rat") "main" ("y",1) (1, "SB")


let%test "testPlacementPointeurRetour_f_p" = 
  test (pathFichiersRat^"testPlacementPointeurRetour.rat") "allouer" ("p",1) (3, "LB")

let%test "testPlacementPointeurRetour_main_q" = 
  test (pathFichiersRat^"testPlacementPointeurRetour.rat") "main" ("q",1) (0, "LB")
|| test (pathFichiersRat^"testPlacementPointeurRetour.rat") "main" ("q",1) (0, "SB")

(* Tests placement procédures *)

let%test "testPlacementProcedureParametre_x" =
  test (pathFichiersRat^"testPlacementProcedureParametre.rat") 
    "afficher" ("x", 1) (-1, "LB")

let%test "testPlacementProcedureParametreMultiple_a" =
  test (pathFichiersRat^"testPlacementProcedureParametreMultiple.rat") 
    "afficher" ("a", 1) (-2, "LB")

let%test "testPlacementProcedureParametreMultiple_b" =
  test (pathFichiersRat^"testPlacementProcedureParametreMultiple.rat") 
    "afficher" ("b", 1) (-1, "LB")

let%test "testPlacementProcedureLocale_x" =
  test (pathFichiersRat^"testPlacementProcedureLocale.rat") 
    "afficher" ("x", 1) (-1, "LB")

let%test "testPlacementProcedureLocale_y" =
  test (pathFichiersRat^"testPlacementProcedureLocale.rat") 
    "afficher" ("y", 1) (3, "LB")

let%test "testPlacementProcedureRatParam_r" =
  test (pathFichiersRat^"testPlacementProcedureRatParam.rat") 
    "afficher" ("r", 1) (-2, "LB")

let%test "testPlacementProcedurePointeurParam_p" =
  test (pathFichiersRat^"testPlacementProcedurePointeurParam.rat") 
    "afficher" ("p", 1) (-1, "LB")

let%test "testPlacementProcedureMixte_x" =
  test (pathFichiersRat^"testPlacementProcedureMixte.rat") 
    "afficher" ("x", 1) (-3, "LB")

let%test "testPlacementProcedureMixte_r" =
  test (pathFichiersRat^"testPlacementProcedureMixte.rat") 
    "afficher" ("r", 1) (-2, "LB")

let%test "testPlacementProcedureMixte_y" =
  test (pathFichiersRat^"testPlacementProcedureMixte.rat") 
    "afficher" ("y", 1) (3, "LB")

(* Tests passage par référence  *)


let%test "testPlacementRefParam_a" =
  test (pathFichiersRat^"testPlacementRefParam.rat") "f" ("a", 1) (-1, "LB")

let%test "testPlacementRefMultiple_a" =
  test (pathFichiersRat^"testPlacementRefMultiple.rat") "echanger" ("a", 1) (-2, "LB")

let%test "testPlacementRefMultiple_b" =
  test (pathFichiersRat^"testPlacementRefMultiple.rat") "echanger" ("b", 1) (-1, "LB")

let%test "testPlacementRefMultiple_tmp" =
  test (pathFichiersRat^"testPlacementRefMultiple.rat") "echanger" ("tmp", 1) (3, "LB")

let%test "testPlacementRefMixte_a" =
  test (pathFichiersRat^"testPlacementRefMixte.rat") "f" ("a", 1) (-3, "LB")

let%test "testPlacementRefMixte_b" =
  test (pathFichiersRat^"testPlacementRefMixte.rat") "f" ("b", 1) (-2, "LB")

let%test "testPlacementRefMixte_c" =
  test (pathFichiersRat^"testPlacementRefMixte.rat") "f" ("c", 1) (-1, "LB")


let%test "testPlacementRefLocale_a" =
  test (pathFichiersRat^"testPlacementRefLocale.rat") "f" ("a", 1) (-1, "LB")

let%test "testPlacementRefLocale_y" =
  test (pathFichiersRat^"testPlacementRefLocale.rat") "f" ("y", 1) (3, "LB")


let%test "testPlacementRefRat_r" =
  test (pathFichiersRat^"testPlacementRefRat.rat") "doubler" ("r", 1) (-1, "LB")


let%test "testPlacementRefPointeur_p" =
  test (pathFichiersRat^"testPlacementRefPointeur.rat") "modifier" ("p", 1) (-1, "LB")

(*Test pour Enumeration*)
let%test "testPlacementEnum_main_j" = 
  test (pathFichiersRat^"testPlacementEnum.rat") "main" ("j",1) (0, "SB")
  || test (pathFichiersRat^"testPlacementEnum.rat") "main" ("j",1) (0, "LB")

let%test "testPlacementEnum_f_e" = 
  
  test (pathFichiersRat^"testPlacementEnum.rat") "f" ("e",1) (-2, "LB")

let%test "testPlacementEnum_f_i" = 
 
  test (pathFichiersRat^"testPlacementEnum.rat") "f" ("i",1) (-1, "LB")

let%test "testPlacementEnum_f_loc" = 

  test (pathFichiersRat^"testPlacementEnum.rat") "f" ("loc",1) (3, "LB")