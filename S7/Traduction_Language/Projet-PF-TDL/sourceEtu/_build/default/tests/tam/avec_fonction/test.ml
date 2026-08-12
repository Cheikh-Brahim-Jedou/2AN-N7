open Rat
open Compilateur

(* Changer le chemin d'accès du jar. *)
let runtamcmde = "java -jar ../../../../../tests/runtam.jar"
(* let runtamcmde = "java -jar /mnt/n7fs/.../tools/runtam/runtam.jar" *)

(* Execute the TAM code obtained from the rat file and return the ouptut of this code *)
let runtamcode cmde ratfile =
  let tamcode = compiler ratfile in
  let (tamfile, chan) = Filename.open_temp_file "test" ".tam" in
  output_string chan tamcode;
  close_out chan;
  let ic = Unix.open_process_in (cmde ^ " " ^ tamfile) in
  let printed = input_line ic in
  close_in ic;
  Sys.remove tamfile;    (* à commenter si on veut étudier le code TAM. *)
  String.trim printed

(* Compile and run ratfile, then print its output *)
let runtam ratfile =
  print_string (runtamcode runtamcmde ratfile)

(****************************************)
(** Chemin d'accès aux fichiers de test *)
(****************************************)

let pathFichiersRat = "../../../../../tests/tam/avec_fonction/fichiersRat/"

(**********)
(*  TESTS *)
(**********)


(* requires ppx_expect in jbuild, and `opam install ppx_expect` *)
let%expect_test "testfun1" =
  runtam (pathFichiersRat^"testfun1.rat");
  [%expect{| 1 |}]

let%expect_test "testfun2" =
  runtam (pathFichiersRat^"testfun2.rat");
  [%expect{| 7 |}]

let%expect_test "testfun3" =
  runtam (pathFichiersRat^"testfun3.rat");
  [%expect{| 10 |}]

let%expect_test "testfun4" =
  runtam (pathFichiersRat^"testfun4.rat");
  [%expect{| 10 |}]

let%expect_test "testfun5" =
  runtam (pathFichiersRat^"testfun5.rat");
  [%expect{| |}]

let%expect_test "testfun6" =
  runtam (pathFichiersRat^"testfun6.rat");
  [%expect{|truetrue|}]

let%expect_test "testfuns" =
  runtam (pathFichiersRat^"testfuns.rat");
  [%expect{| 28 |}]

let%expect_test "factrec" =
  runtam (pathFichiersRat^"factrec.rat");
  [%expect{| 120 |}]

  (* Tests TAM avec fonction pour les pointeurs - À AJOUTER *)

let%expect_test "testPointeurParam" =
  runtam (pathFichiersRat^"testPointeurParam.rat");
  [%expect{| 42 |}]

let%expect_test "testPointeurParamMultiple" =
  runtam (pathFichiersRat^"testPointeurParamMultiple.rat");
  [%expect{| 42 |}]

let%expect_test "testPointeurRetour" =
  runtam (pathFichiersRat^"testPointeurRetour.rat");
  [%expect{| 42 |}]

let%expect_test "testPointeurRatParam" =
  runtam (pathFichiersRat^"testPointeurRatParam.rat");
  [%expect{| 3 |}]

let%expect_test "testPointeurDoubleParam" =
  runtam (pathFichiersRat^"testPointeurDoubleParam.rat");
  [%expect{| 42 |}]

(* Tests procédures avec fonction - TAM *)

let%expect_test "testTamProcedureAppelFonction" =
  runtam (pathFichiersRat^"testTamProcedureAppelFonction.rat");
  [%expect{| 42 |}]

let%expect_test "testTamFonctionAppelProcedure" =
  runtam (pathFichiersRat^"testTamFonctionAppelProcedure.rat");
  [%expect{| 56 |}]

let%expect_test "testTamProcedureRecursive" =
  runtam (pathFichiersRat^"testTamProcedureRecursive.rat");
  [%expect{| 0123 |}]

let%expect_test "testTamProcedureParametreLocal" =
  runtam (pathFichiersRat^"testTamProcedureParametreLocal.rat");
  [%expect{| 42 |}]

let%expect_test "testTamProcedureRat" =
  runtam (pathFichiersRat^"testTamProcedureRat.rat");
  [%expect{| [3/4] |}]

let%expect_test "testTamProcedurePointeur" =
  runtam (pathFichiersRat^"testTamProcedurePointeur.rat");
  [%expect{| 42 |}]

let%expect_test "testTamProcedureModificationPointeur" =
  runtam (pathFichiersRat^"testTamProcedureModificationPointeur.rat");
  [%expect{| 42 |}]

let%expect_test "testTamProcedureMultipleAppels" =
  runtam (pathFichiersRat^"testTamProcedureMultipleAppels.rat");
  [%expect{| 123 |}]

let%expect_test "testTamProcedureBoucle" =
  runtam (pathFichiersRat^"testTamProcedureBoucle.rat");
  [%expect{| 777 |}]

let%expect_test "testTamProcedureConditionnelle" =
  runtam (pathFichiersRat^"testTamProcedureConditionnelle.rat");
  [%expect{| 01 |}]

(* Tests passage par référence - TAM *)
let%expect_test "testTamRefSimple" =
  runtam (pathFichiersRat^"testTamRefSimple.rat");
  [%expect{| 1 |}]

let%expect_test "testTamRefEchange" =
  runtam (pathFichiersRat^"testTamRefEchange.rat");
  [%expect{| 105 |}]

let%expect_test "testTamRefRat" =
  runtam (pathFichiersRat^"testTamRefRat.rat");
  [%expect{| [3/2] |}]

let%expect_test "testTamRefChaine" =
  runtam (pathFichiersRat^"testTamRefChaine.rat");
  [%expect{| 6 |}]

(* Tests TAM avec fonction pour les enums *)

let%expect_test "testTamEnum" =
  runtam (pathFichiersRat^"testTamEnum.rat");
  [%expect{| 199 |}]

let%expect_test "testReferenceChaining" =
  runtam (pathFichiersRat^"testReferenceChaining.rat");
  [%expect{| 5556565758 |}]

(* Test Combinaison Complexe (Enum, Ref, Pointeur, Procédure) Test du sujet de Projet *)
let%expect_test "testCombinaisonComplexe" =
  runtam (pathFichiersRat^"testCombinaisonComplexe.rat");
  [%expect{| 105101551051510751510 |}]





