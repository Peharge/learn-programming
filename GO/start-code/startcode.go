package main

import "fmt"

// Hauptfunktion
func main() {
    // Begrüßung
    fmt.Println("Willkommen zu meinem Go-Programm!")

    // Nutzereingabe
    var name string
    fmt.Print("Bitte geben Sie Ihren Namen ein: ")
    fmt.Scanln(&name)

    // Begrüßung mit dem Namen
    fmt.Println("Hallo,", name, "! Schön, dass Sie hier sind.")

    // Programm beenden
    fmt.Println("Das Programm wurde beendet.")
}
