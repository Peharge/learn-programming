package main

import (
	"fmt"
)

var board = [9]rune{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
var currentPlayer = 'X'
var gameOver = false

func main() {
	for !gameOver {
		clearScreen()
		displayBoard()
		playerTurn()
		checkGameStatus()
	}
}

func clearScreen() {
	fmt.Print("\033[H\033[2J") // ANSI Escape Codes zum Löschen des Bildschirms
}

func displayBoard() {
	fmt.Println("Spieler 1 = X und Spieler 2 = O")
	fmt.Println()
	fmt.Printf(" %c | %c | %c \n", board[0], board[1], board[2])
	fmt.Println("---|---|---")
	fmt.Printf(" %c | %c | %c \n", board[3], board[4], board[5])
	fmt.Println("---|---|---")
	fmt.Printf(" %c | %c | %c \n", board[6], board[7], board[8])
	fmt.Println()
}

func playerTurn() {
	var choice int
	fmt.Printf("Spieler %c, wähle deine Position (1-9): ", currentPlayer)
	for {
		_, err := fmt.Scan(&choice)
		if err != nil || choice < 1 || choice > 9 || board[choice-1] != ' ' {
			fmt.Println("Ungültige Eingabe, bitte eine freie Position zwischen 1 und 9 wählen.")
		} else {
			board[choice-1] = currentPlayer
			break
		}
	}
	if currentPlayer == 'X' {
		currentPlayer = 'O'
	} else {
		currentPlayer = 'X'
	}
}

func checkGameStatus() {
	// Gewinnmöglichkeiten
	winPatterns := [8][3]int{
		{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Horizontale
		{0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Vertikale
		{0, 4, 8}, {2, 4, 6},            // Diagonal
	}

	for _, pattern := range winPatterns {
		if board[pattern[0]] == board[pattern[1]] && board[pattern[1]] == board[pattern[2]] && board[pattern[0]] != ' ' {
			clearScreen()
			displayBoard()
			fmt.Printf("Spieler %c hat gewonnen!\n", currentPlayer)
			gameOver = true
			return
		}
	}

	// Unentschieden prüfen
	isBoardFull := true
	for _, spot := range board {
		if spot == ' ' {
			isBoardFull = false
			break
		}
	}

	if isBoardFull {
		clearScreen()
		displayBoard()
		fmt.Println("Das Spiel endet Unentschieden!")
		gameOver = true
	}
}
