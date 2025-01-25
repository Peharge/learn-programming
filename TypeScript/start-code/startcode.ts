// Beschreibung: Ein einfaches TypeScript-Programm
// Datum: 25.01.2025

// Begrüßung
console.log("Willkommen zu meinem TypeScript-Programm!");

// Funktion definieren
function begruessung(): void {
    console.log("Das ist eine Beispiel-Funktion in TypeScript.");
}

// Funktion aufrufen
begruessung();

// Nutzereingabe (für Node.js)
import * as readlineSync from 'readline-sync';

const name: string = readlineSync.question("Bitte geben Sie Ihren Namen ein: ");

// Begrüßung mit dem Namen
console.log(`Hallo, ${name}! Schön, dass Sie hier sind.`);

// Programm beenden
console.log("Das Programm wurde beendet.");
