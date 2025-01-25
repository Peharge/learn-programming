(ns startcode.core)

(defn -main []
  (println "Willkommen zu meinem Clojure-Programm!")

  (print "Bitte geben Sie Ihren Namen ein: ")
  (flush) ; Sorgt dafür, dass der Prompt sofort angezeigt wird
  (let [name (read-line)] ; Liest die Eingabe des Nutzers
    (println (str "Hallo, " name "! Schön, dass Sie hier sind.")))

  (println "Das Programm wurde beendet."))

(-main)
