#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    int number, guess, attempts = 0;

    // Zufallszahlengenerator initialisieren
    srand(time(NULL));

    // Zufällige Zahl zwischen 1 und 100 generieren
    number = rand() % 100 + 1;

    printf("Willkommen zum Zahlenratespiel!\n");
    printf("Ich habe mir eine Zahl zwischen 1 und 100 ausgedacht. Versuche sie zu erraten!\n");

    // Spielschleife
    do {
        printf("Gib deine Schätzung ein: ");
        scanf("%d", &guess);

        attempts++;  // Zähler für Versuche erhöhen

        if (guess < number) {
            printf("Zu niedrig! Versuch es noch einmal.\n");
        } else if (guess > number) {
            printf("Zu hoch! Versuch es noch einmal.\n");
        } else {
            printf("Herzlichen Glückwunsch! Du hast die Zahl %d in %d Versuchen erraten.\n", number, attempts);
        }
    } while (guess != number);

    return 0;
}
