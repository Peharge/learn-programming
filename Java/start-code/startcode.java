// Beschreibung: Ein einfaches Java-Programm
// Datum: 25.01.2025

import java.util.Scanner;

public class StartCode {
    public static void main(String[] args) {
        // Begrüßung
        System.out.println("Willkommen zu meinem Java-Programm!");

        // Scanner für Nutzereingabe initialisieren
        Scanner scanner = new Scanner(System.in);

        // Nutzereingabe abfragen
        System.out.print("Bitte geben Sie Ihren Namen ein: ");
        String name = scanner.nextLine();

        // Begrüßung mit dem Namen
        System.out.println("Hallo, " + name + "! Schön, dass Sie hier sind.");

        // Scanner schließen
        scanner.close();

        // Programm beenden
        System.out.println("Das Programm wurde beendet.");
    }
}
