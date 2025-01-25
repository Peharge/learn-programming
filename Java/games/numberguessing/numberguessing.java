import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Zufallszahl zwischen 1 und 100 generieren
        int numberToGuess = random.nextInt(100) + 1;
        int userGuess = 0;
        int numberOfTries = 0;

        System.out.println("Willkommen zum Zahlenraten-Spiel!");
        System.out.println("Ich habe eine Zahl zwischen 1 und 100 gewählt. Versuche, sie zu erraten.");

        // Solange der Benutzer die Zahl nicht errät
        while (userGuess != numberToGuess) {
            System.out.print("Gib deine Schätzung ein: ");
            userGuess = scanner.nextInt();
            numberOfTries++;

            // Eingabe des Benutzers auswerten
            if (userGuess < numberToGuess) {
                System.out.println("Die gesuchte Zahl ist größer.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Die gesuchte Zahl ist kleiner.");
            } else {
                System.out.println("Herzlichen Glückwunsch! Du hast die Zahl " + numberToGuess + " erraten.");
                System.out.println("Du hast " + numberOfTries + " Versuche gebraucht.");
            }
        }

        scanner.close();
    }
}
