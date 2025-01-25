#include <stdio.h>

char board[3][3]; // Spielfeld
char currentPlayer = 'X'; // Der erste Spieler ist X

// Funktion zum Initialisieren des Spielfeldes
void initializeBoard() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j] = ' '; // Leere Felder
        }
    }
}

// Funktion, um das Spielfeld anzuzeigen
void printBoard() {
    printf("\n");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf(" %c ", board[i][j]);
            if (j < 2) printf("|");
        }
        printf("\n");
        if (i < 2) {
            printf("---|---|---\n");
        }
    }
    printf("\n");
}

// Funktion, um zu überprüfen, ob der aktuelle Spieler gewonnen hat
int checkWin() {
    // Zeilen überprüfen
    for (int i = 0; i < 3; i++) {
        if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
            return 1;
        }
    }

    // Spalten überprüfen
    for (int i = 0; i < 3; i++) {
        if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
            return 1;
        }
    }

    // Diagonalen überprüfen
    if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
        return 1;
    }
    if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
        return 1;
    }

    return 0;
}

// Funktion, um zu überprüfen, ob das Spielfeld voll ist (Unentschieden)
int checkDraw() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == ' ') {
                return 0; // Es gibt noch freie Felder
            }
        }
    }
    return 1; // Alle Felder sind besetzt
}

// Funktion für das Zug des Spielers
void playerMove() {
    int row, col;
    while (1) {
        printf("Spieler %c, geben Sie eine Zeile (1-3) und eine Spalte (1-3) ein: ", currentPlayer);
        scanf("%d %d", &row, &col);

        // Überprüfen, ob die Eingabe im gültigen Bereich liegt
        if (row >= 1 && row <= 3 && col >= 1 && col <= 3 && board[row - 1][col - 1] == ' ') {
            board[row - 1][col - 1] = currentPlayer;
            break;
        } else {
            printf("Ungültiger Zug! Versuchen Sie es erneut.\n");
        }
    }
}

// Funktion zum Wechseln des Spielers
void switchPlayer() {
    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
}

int main() {
    initializeBoard();
    printBoard();

    while (1) {
        playerMove();
        printBoard();

        if (checkWin()) {
            printf("Spieler %c hat gewonnen!\n", currentPlayer);
            break;
        }

        if (checkDraw()) {
            printf("Das Spiel endet unentschieden!\n");
            break;
        }

        switchPlayer();
    }

    return 0;
}
