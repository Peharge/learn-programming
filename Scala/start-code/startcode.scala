// Beschreibung: Ein einfaches Scala-Programm
// Datum: 25.01.2025

object Main {
  def main(args: Array[String]): Unit = {
    // Begrüßung
    println("Willkommen zu meinem Scala-Programm!")

    // Funktion definieren
    def begruessung(): Unit = {
      println("Das ist eine Beispiel-Funktion in Scala.")
    }

    // Funktion aufrufen
    begruessung()

    // Nutzereingabe
    print("Bitte geben Sie Ihren Namen ein: ")
    val name = scala.io.StdIn.readLine()

    // Begrüßung mit dem Namen
    println(s"Hallo, $name! Schön, dass Sie hier sind.")

    // Programm beenden
    println("Das Programm wurde beendet.")
  }
}
