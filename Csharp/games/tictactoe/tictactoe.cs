using System;

class Program
{
    static char[] board = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
    static int currentPlayer = 1; // Spieler 1 beginnt
    static bool gameOver = false;

    static void Main(string[] args)
    {
        while (!gameOver)
        {
            Console.Clear();
            DisplayBoard();
            PlayerTurn();
            CheckGameStatus();
        }
    }

    // Brett anzeigen
    static void DisplayBoard()
    {
        Console.WriteLine("Spieler 1 = X und Spieler 2 = O");
        Console.WriteLine();
        Console.WriteLine($" {board[0]} | {board[1]} | {board[2]} ");
        Console.WriteLine("---|---|---");
        Console.WriteLine($" {board[3]} | {board[4]} | {board[5]} ");
        Console.WriteLine("---|---|---");
        Console.WriteLine($" {board[6]} | {board[7]} | {board[8]} ");
        Console.WriteLine();
    }

    // Spielerzug
    static void PlayerTurn()
    {
        int choice;
        Console.WriteLine($"Spieler {currentPlayer}, wähle deine Position (1-9): ");
        while (true)
        {
            string input = Console.ReadLine();
            if (int.TryParse(input, out choice) && choice >= 1 && choice <= 9 && board[choice - 1] == ' ')
            {
                board[choice - 1] = currentPlayer == 1 ? 'X' : 'O';
                break;
            }
            else
            {
                Console.WriteLine("Ungültige Eingabe, bitte eine freie Position zwischen 1 und 9 wählen.");
            }
        }

        currentPlayer = (currentPlayer == 1) ? 2 : 1; // Wechsel zum nächsten Spieler
    }

    // Überprüfen, ob das Spiel beendet ist
    static void CheckGameStatus()
    {
        // Gewinnmöglichkeiten
        int[,] winPatterns = {
            { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, // Horizontale
            { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, // Vertikale
            { 0, 4, 8 }, { 2, 4, 6 }              // Diagonal
        };

        foreach (var pattern in winPatterns)
        {
            if (board[pattern[0]] == board[pattern[1]] && board[pattern[1]] == board[pattern[2]] && board[pattern[0]] != ' ')
            {
                Console.Clear();
                DisplayBoard();
                Console.WriteLine($"Spieler {(currentPlayer == 1 ? 2 : 1)} hat gewonnen!");
                gameOver = true;
                return;
            }
        }

        // Unentschieden prüfen
        bool isBoardFull = true;
        foreach (var spot in board)
        {
            if (spot == ' ')
            {
                isBoardFull = false;
                break;
            }
        }

        if (isBoardFull)
        {
            Console.Clear();
            DisplayBoard();
            Console.WriteLine("Das Spiel endet Unentschieden!");
            gameOver = true;
        }
    }
}
