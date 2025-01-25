package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	// Zufallszahlengenerator initialisieren
	rand.Seed(time.Now().UnixNano())

	// Zufallszahl zwischen 1 und 100 generieren
	number := rand.Intn(100) + 1
	var guess int
	attempts := 0

	fmt.Println("Willkommen zum Zahlenratespiel!")
	fmt.Println("Ich habe mir eine Zahl zwischen 1 und 100 ausgedacht. Versuche sie zu erraten!")

	// Spielschleife
	for guess != number {
		fmt.Print("Gib deine Schätzung ein: ")
		_, err := fmt.Scanf("%d", &guess)

		if err != nil {
			fmt.Println("Ungültige Eingabe! Bitte gib eine Zahl ein.")
			// Eingabefehler behandeln
			continue
		}

		attempts++ // Zähler für Versuche erhöhen

		if guess < number {
			fmt.Println("Zu niedrig! Versuch es noch einmal.")
		} else if guess > number {
			fmt.Println("Zu hoch! Versuch es noch einmal.")
		} else {
			fmt.Printf("Herzlichen Glückwunsch! Du hast die Zahl %d in %d Versuchen erraten.\n", number, attempts)
		}
	}
}
