import kotlin.random.Random

fun main() {
    // Zufallszahl zwischen 1 und 100 generieren
    val number = Random.nextInt(1, 101)
    var guess: Int
    var attempts = 0

    println("Willkommen zum Zahlenratespiel!")
    println("Ich habe mir eine Zahl zwischen 1 und 100 ausgedacht. Versuche sie zu erraten!")

    // Spielschleife
    do {
        println("Gib deine Schätzung ein:")
        val input = readLine()

        // Überprüfen, ob die Eingabe eine gültige Zahl ist
        try {
            guess = input?.toInt() ?: throw NumberFormatException()
            attempts++  // Zähler für Versuche erhöhen

            if (guess < number) {
                println("Zu niedrig! Versuch es noch einmal.")
            } else if (guess > number) {
                println("Zu hoch! Versuch es noch einmal.")
            } else {
                println("Herzlichen Glückwunsch! Du hast die Zahl $number in $attempts Versuchen erraten.")
            }
        } catch (e: Exception) {
            println("Bitte gib eine gültige Zahl ein.")
        }
    } while (guess != number)
}
