import java.util.Scanner;

public class TicTacToe {

    public static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        printBoard();

        while (!gameWon) {
            System.out.println("Spieler " + currentPlayer + ", gib deine Zeile (1-3) und Spalte (1-3) ein (z.B. 1 1):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Überprüfen, ob die Eingabe gültig ist
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                printBoard();

                // Überprüfen, ob der aktuelle Spieler gewonnen hat
                if (checkWinner()) {
                    gameWon = true;
                    System.out.println("Spieler " + currentPlayer + " hat gewonnen!");
                } else if (isBoardFull()) {
                    gameWon = true;
                    System.out.println("Unentschieden!");
                }

                // Wechseln zum anderen Spieler
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Ungültige Eingabe, versuche es erneut.");
            }
        }
        scanner.close();
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static boolean checkWinner() {
        // Überprüfen der Reihen
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }

        // Überprüfen der Spalten
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Überprüfen der Diagonalen
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
