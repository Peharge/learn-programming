fun main() {
    var board = Array(3) { Array(3) { ' ' } }
    var currentPlayer = 'X'
    var gameOver = false

    while (!gameOver) {
        printBoard(board)
        playerTurn(board, currentPlayer)
        gameOver = checkGameStatus(board)
        currentPlayer = if (currentPlayer == 'X') 'O' else 'X' // Wechsel zum nächsten Spieler
    }

    println("Spiel beendet!")
}

fun printBoard(board: Array<Array<Char>>) {
    println("\nTic-Tac-Toe")
    println("Spieler 1 = X und Spieler 2 = O")
    println()
    for (row in board) {
        println(row.joinToString(" | "))
        println("---------")
    }
}

fun playerTurn(board: Array<Array<Char>>, currentPlayer: Char) {
    var validMove = false
    while (!validMove) {
        println("Spieler $currentPlayer, wähle eine Zeile (1-3) und eine Spalte (1-3): ")
        try {
            val row = readLine()!!.toInt() - 1
            val col = readLine()!!.toInt() - 1
            if (row in 0..2 && col in 0..2 && board[row][col] == ' ') {
                board[row][col] = currentPlayer
                validMove = true
            } else {
                println("Ungültiger Zug, das Feld ist bereits besetzt oder außerhalb des Bereichs.")
            }
        } catch (e: Exception) {
            println("Ungültige Eingabe. Bitte versuche es noch einmal.")
        }
    }
}

fun checkGameStatus(board: Array<Array<Char>>): Boolean {
    // Überprüfen auf einen Gewinner
    val winPatterns = listOf(
        // Horizontale Linien
        listOf(Pair(0, 0), Pair(0, 1), Pair(0, 2)),
        listOf(Pair(1, 0), Pair(1, 1), Pair(1, 2)),
        listOf(Pair(2, 0), Pair(2, 1), Pair(2, 2)),
        // Vertikale Linien
        listOf(Pair(0, 0), Pair(1, 0), Pair(2, 0)),
        listOf(Pair(0, 1), Pair(1, 1), Pair(2, 1)),
        listOf(Pair(0, 2), Pair(1, 2), Pair(2, 2)),
        // Diagonalen
        listOf(Pair(0, 0), Pair(1, 1), Pair(2, 2)),
        listOf(Pair(0, 2), Pair(1, 1), Pair(2, 0))
    )

    for (pattern in winPatterns) {
        val (a, b, c) = pattern
        if (board[a.first][a.second] == board[b.first][b.second] &&
            board[b.first][b.second] == board[c.first][c.second] &&
            board[a.first][a.second] != ' ') {
            println("Spieler ${board[a.first][a.second]} hat gewonnen!")
            return true
        }
    }

    // Überprüfen auf ein Unentschieden
    if (board.flatten().none { it == ' ' }) {
        println("Das Spiel endet Unentschieden!")
        return true
    }

    return false
}
