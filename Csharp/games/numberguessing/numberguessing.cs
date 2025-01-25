using System;

class Program
{
    static void Main()
    {
        Random random = new Random();
        int number = random.Next(1, 101); // Zufallszahl zwischen 1 und 100
        int guess = 0;
        int attempts = 0;

        Console.WriteLine("Willkommen zum Zahlenratespiel!");
        Console.WriteLine("Ich habe mir eine Zahl zwischen 1 und 100 ausgedacht. Versuche sie zu erraten!");

        // Spielschleife
        while (guess != number)
        {
            Console.Write("Gib deine Schätzung ein: ");
            string input = Console.ReadLine();

            // Eingabe validieren
            if (int.TryParse(input, out guess))
            {
                attempts++; // Zähler für Versuche erhöhen

                if (guess < number)
                {
                    Console.WriteLine("Zu niedrig! Versuch es noch einmal.");
                }
                else if (guess > number)
                {
                    Console.WriteLine("Zu hoch! Versuch es noch einmal.");
                }
                else
                {
                    Console.WriteLine($"Herzlichen Glückwunsch! Du hast die Zahl {number} in {attempts} Versuchen erraten.");
                }
            }
            else
            {
                Console.WriteLine("Bitte gib eine gültige Zahl ein.");
            }
        }
    }
}
