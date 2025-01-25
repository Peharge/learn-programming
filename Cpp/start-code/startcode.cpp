#include <iostream>
#include <string>

// Beschreibung: Ein einfaches C++-Programm
// Datum: 25.01.2025

int main() {
    // Begrüßung
    std::cout << "Willkommen zu meinem C++-Programm!" << std::endl;

    // Variablen definieren
    std::string name;

    // Nutzereingabe
    std::cout << "Bitte geben Sie Ihren Namen ein: ";
    std::getline(std::cin, name); // Name einlesen (inkl. Leerzeichen)

    // Begrüßung mit dem Namen
    std::cout << "Hallo, " << name << "! Schön, dass Sie hier sind." << std::endl;

    // Programm beenden
    std::cout << "Das Programm wurde beendet." << std::endl;

    return 0;
}
