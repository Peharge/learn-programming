#include <stdio.h>

// Beschreibung: Ein einfaches C-Programm
// Datum: 25.01.2025

// Hauptfunktion
int main() {
    // Begrüßung
    printf("Willkommen zu meinem C-Programm!\n");

    // Variablen definieren
    char name[50];

    // Nutzereingabe
    printf("Bitte geben Sie Ihren Namen ein: ");
    scanf("%49s", name); // Eingabe des Namens (maximal 49 Zeichen)

    // Begrüßung mit dem Namen
    printf("Hallo, %s! Schön, dass Sie hier sind.\n", name);

    // Programm beenden
    printf("Das Programm wurde beendet.\n");
    return 0;
}
