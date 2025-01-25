open System

// Begrüßung
Console.WriteLine("Willkommen zu meinem F#-Programm!")

// Nutzereingabe
Console.Write("Bitte geben Sie Ihren Namen ein: ")
let name = Console.ReadLine()

// Begrüßung mit dem Namen
Console.WriteLine($"Hallo, {name}! Schön, dass Sie hier sind.")
Console.WriteLine("Das Programm wurde beendet.")
