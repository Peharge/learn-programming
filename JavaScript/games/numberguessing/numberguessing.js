// Zufallszahl zwischen 1 und 100 generieren
let number = Math.floor(Math.random() * 100) + 1;
let guess = 0;
let attempts = 0;

alert("Willkommen zum Zahlenratespiel!");
alert("Ich habe mir eine Zahl zwischen 1 und 100 ausgedacht. Versuche sie zu erraten!");

// Spielschleife
while (guess !== number) {
    // Eingabe des Benutzers abfragen
    guess = parseInt(prompt("Gib deine Schätzung ein:"));

    // Überprüfen, ob die Eingabe eine gültige Zahl ist
    if (isNaN(guess)) {
        alert("Bitte gib eine gültige Zahl ein.");
        continue;
    }

    attempts++; // Versuche erhöhen

    // Feedback
    if (guess < number) {
        alert("Zu niedrig! Versuch es noch einmal.");
    } else if (guess > number) {
        alert("Zu hoch! Versuch es noch einmal.");
    } else {
        alert(`Herzlichen Glückwunsch! Du hast die Zahl ${number} in ${attempts} Versuchen erraten.`);
    }
}
