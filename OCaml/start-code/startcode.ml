(* Beschreibung: Ein einfaches OCaml-Programm *)
(* Datum: 25.01.2025 *)

(* Begrüßung *)
print_endline "Willkommen zu meinem OCaml-Programm!";;

(* Funktion definieren *)
let begruessung () =
  print_endline "Das ist eine Beispiel-Funktion in OCaml."
;;

(* Funktion aufrufen *)
begruessung ();;

(* Nutzereingabe *)
print_endline "Bitte geben Sie Ihren Namen ein: ";;
let name = read_line ();;

(* Begrüßung mit dem Namen *)
print_endline ("Hallo, " ^ name ^ "! Schön, dass Sie hier sind.");;

(* Programm beenden *)
print_endline "Das Programm wurde beendet."
