open Rat
open Compilateur
open Exceptions

exception ErreurNonDetectee

(****************************************)
(** Chemin d'accès aux fichiers de test *)
(****************************************)

let pathFichiersRat = "../../../../../tests/type/avec_fonction/fichiersRat/"

(**********)
(*  TESTS *)
(**********)


let%test_unit "test2"= 
  let _ = compiler (pathFichiersRat^"test2.rat") in ()

let%test_unit "testAppel1"= 
  let _ = compiler (pathFichiersRat^"testAppel1.rat") in ()

let%test_unit "testAppel2"= 
  let _ = compiler (pathFichiersRat^"testAppel2.rat") in ()

let%test_unit "testAppel3"= 
  let _ = compiler (pathFichiersRat^"testAppel3.rat") in ()

let%test_unit "testAppel4"= 
  let _ = compiler (pathFichiersRat^"testAppel4.rat") in ()

let%test_unit "testAppel5"= 
  let _ = compiler (pathFichiersRat^"testAppel5.rat") in ()

let%test_unit "testAppel6"= 
  try 
    let _ = compiler (pathFichiersRat^"testAppel6.rat")
    in raise ErreurNonDetectee
  with
  | TypesParametresInattendus _ -> ()

let%test_unit "testAppel7"= 
  try 
    let _ = compiler (pathFichiersRat^"testAppel7.rat")
    in raise ErreurNonDetectee
  with
  | TypesParametresInattendus _ -> ()

let%test_unit "testAppel8"= 
  try 
    let _ = compiler (pathFichiersRat^"testAppel8.rat")
    in raise ErreurNonDetectee
  with
  | TypesParametresInattendus _ -> ()

let%test_unit "testAppel9"= 
  try 
    let _ = compiler (pathFichiersRat^"testAppel9.rat")
    in raise ErreurNonDetectee
  with
  | TypesParametresInattendus _ -> ()

let%test_unit "testAppel10"= 
  try 
    let _ = compiler (pathFichiersRat^"testAppel10.rat")
    in raise ErreurNonDetectee
  with
  | TypesParametresInattendus _  -> ()

let%test_unit "testAppel11"= 
  try 
    let _ = compiler (pathFichiersRat^"testAppel11.rat")
    in raise ErreurNonDetectee
  with
  | TypesParametresInattendus _  -> ()

let%test_unit "testAppel12"= 
  try 
    let _ = compiler (pathFichiersRat^"testAppel12.rat")
    in raise ErreurNonDetectee
  with
  | TypeInattendu(Int,Bool) -> ()

let%test_unit "testAppel13"= 
  try 
    let _ = compiler (pathFichiersRat^"testAppel13.rat")
    in raise ErreurNonDetectee
  with
  | TypeInattendu(Int,Rat) -> ()

let%test_unit "testRetourFonction1"= 
  let _ = compiler (pathFichiersRat^"testRetourFonction1.rat") in ()

let%test_unit "testRetourFonction2"= 
  try 
    let _ = compiler (pathFichiersRat^"testRetourFonction2.rat")
    in raise ErreurNonDetectee
  with
  | TypeInattendu(Bool,Int) -> ()

let%test_unit "testRetourFonction3"=
  let _ = compiler (pathFichiersRat^"testRetourFonction3.rat") in ()

let%test_unit "testRetourFonction4"=
  try
    let _ = compiler (pathFichiersRat^"testRetourFonction4.rat")
    in raise ErreurNonDetectee
  with
  | TypeInattendu(Bool,Int) -> ()

let%test_unit "testRecursiviteFonction"= 
  let _ = compiler (pathFichiersRat^"testRecursiviteFonction.rat") in ()

let%test_unit "test"= 
  let _ = compiler (pathFichiersRat^"test.rat") in ()

let%test_unit "code_factrec" = 
let _ = compiler   (pathFichiersRat^"factrec.rat") in ()

(* Tests procédures avec fonction  *)

let%test_unit "testTypeProcedureAppelFonction" =
  let _ = compiler (pathFichiersRat^"testTypeProcedureAppelFonction.rat") in ()

let%test_unit "testTypeFonctionAppelProcedure" =
  let _ = compiler (pathFichiersRat^"testTypeFonctionAppelProcedure.rat") in ()

let%test_unit "testTypeProcedureRetourAvecValeur" =
  try
    let _ = compiler (pathFichiersRat^"testTypeProcedureRetourAvecValeur.rat")
    in raise ErreurNonDetectee
  with
  | TypeInattendu(Int, Void) -> ()

let%test_unit "testTypeFonctionRetourVoid" =
  try
    let _ = compiler (pathFichiersRat^"testTypeFonctionRetourVoid.rat")
    in raise ErreurNonDetectee
  with
  | TypeInattendu(Void, Int) -> ()

let%test_unit "testTypeProcedureParametreIncorrect" =
  try
    let _ = compiler (pathFichiersRat^"testTypeProcedureParametreIncorrect.rat")
    in raise ErreurNonDetectee
  with
  | TypesParametresInattendus _ -> ()

let%test_unit "testTypeProcedureUtiliseeCommeFonction" =
  try
    let _ = compiler (pathFichiersRat^"testTypeProcedureUtiliseeCommeFonction.rat")
    in raise ErreurNonDetectee
  with
  | TypeInattendu(Void, Int) -> ()

let%test_unit "testTypeFonctionUtiliseeCommeProcedure" =
  try
    let _ = compiler (pathFichiersRat^"testTypeFonctionUtiliseeCommeProcedure.rat")
    in raise ErreurNonDetectee
  with
  | MauvaiseUtilisationIdentifiant _ -> ()


let%test_unit "testTypeProcedureRat" =
  let _ = compiler (pathFichiersRat^"testTypeProcedureRat.rat") in ()

let%test_unit "testTypeProcedurePointeur" =
  let _ = compiler (pathFichiersRat^"testTypeProcedurePointeur.rat") in ()

let%test_unit "testTypeProcedureRetourConditionnelIncorrect" =
  try
    let _ = compiler (pathFichiersRat^"testTypeProcedureRetourConditionnelIncorrect.rat")
    in raise ErreurNonDetectee
  with
  | TypeInattendu(Int, Void) -> ()

(* Tests passage par référence  *)

let%test_unit "testTypeRefSimple" =
  let _ = compiler (pathFichiersRat^"testTypeRefSimple.rat") in ()

let%test_unit "testTypeRefManquant" =
  try
    let _ = compiler (pathFichiersRat^"testTypeRefManquant.rat")
    in raise ErreurNonDetectee
  with
  | PassageRefIncoherent -> ()  

let%test_unit "testTypeRefEnTrop" =
  try
    let _ = compiler (pathFichiersRat^"testTypeRefEnTrop.rat")
    in raise ErreurNonDetectee
  with
  | PassageRefIncoherent -> ()

let%test_unit "testTypeRefExpression" =
  try
    let _ = compiler (pathFichiersRat^"testTypeRefExpression.rat")
    in raise ErreurNonDetectee
  with
  | MauvaiseUtilisationIdentifiant _ -> ()  

let%test_unit "testTypeRefRat" =
  let _ = compiler (pathFichiersRat^"testTypeRefRat.rat") in ()

let%test_unit "testTypeRefPointeur" =
  let _ = compiler (pathFichiersRat^"testTypeRefPointeur.rat") in ()

let%test_unit "testEnumTypageCorrecte" = 
  let _ = compiler (pathFichiersRat^"testEnumTypageCorrecte.rat") in ()

let%test_unit "testEnumTypageInvalide" = 
  try 
    let _ = compiler (pathFichiersRat^"testEnumTypageInvalide.rat")
    in raise ErreurNonDetectee
  with
  | TypeBinaireInattendu(_, Enum "Jour", Enum "Mois") -> ()
  | TypeBinaireInattendu(_, Enum "Mois", Enum "Jour") -> ()

let%test_unit "testEnumArithmetique" = 
  try 
    let _ = compiler (pathFichiersRat^"testEnumArithmetique.rat")
    in raise ErreurNonDetectee
  with
  
  | TypeBinaireInattendu(_, Enum "Jour", Int) -> ()


let%test_unit "testEnumAffectation" = 
  try 
    let _ = compiler (pathFichiersRat^"testEnumAffectation.rat")
    in raise ErreurNonDetectee
  with
  | TypeInattendu(Enum "Jour", Int) -> ()

(* Fichiers de tests de la génération de code -> doivent passer la TDS *)
open Unix
open Filename

let rec test d p_tam = 
  try 
    let file = readdir d in
    if (check_suffix file ".rat") 
    then
    (
     try
       let _ = compiler  (p_tam^file) in (); 
     with e -> print_string (p_tam^file); print_newline(); raise e;
    )
    else ();
    test d p_tam
  with End_of_file -> ()

let%test_unit "all_tam" =
  let p_tam = "../../../../../tests/tam/avec_fonction/fichiersRat/" in
  let d = opendir p_tam in
  test d p_tam