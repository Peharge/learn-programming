// Beschreibung: Ein einfaches Swift-Programm
// Datum: 25.01.2025

import Foundation

// Begrüßung
print("Willkommen zu meinem Swift-Programm!")

// Funktion definieren
func begruessung() {
    print("Das ist eine Beispiel-Funktion in Swift.")
}

// Funktion aufrufen
begruessung()

// Nutzereingabe
print("Bitte geben Sie Ihren Namen ein: ", terminator: "")
if let name = readLine() {
    // Begrüßung mit dem Namen
    print("Hallo, \(name)! Schön, dass Sie hier sind.")
}

// Programm beenden
print("Das Programm wurde beendet.")
