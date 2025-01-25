using System;

# Beschreibung: Ein einfaches Bash-Skript
# Datum: 25.01.2025

namespace StartCode
{
    class Program
    {
        // Hauptfunktion
        static void Main(string[] args)
        {
            // Begrüßung
            Console.WriteLine("Willkommen zu meinem C#-Programm!");

            // Variablen definieren
            Console.Write("Bitte geben Sie Ihren Namen ein: ");
            string name = Console.ReadLine(); // Name einlesen

            // Begrüßung mit dem Namen
            Console.WriteLine($"Hallo, {name}! Schön, dass Sie hier sind.");

            // Programm beenden
            Console.WriteLine("Das Programm wurde beendet.");
        }
    }
}
