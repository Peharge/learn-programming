// Beschreibung: Ein einfaches JavaScript-Programm
// Datum: 25.01.2025

// Begrüßung
console.log("Willkommen zu meinem JavaScript-Programm!");

// Funktion definieren
function begruessung() {
    console.log("Das ist eine Beispiel-Funktion.");
}

// Funktion aufrufen
begruessung();

// Nutzereingabe simulieren (da es in Node.js keine direkte Eingabe wie im Browser gibt)
const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

readline.question("Bitte geben Sie Ihren Namen ein: ", (name) => {
    console.log(`Hallo, ${name}! Schön, dass Sie hier sind.`);
    readline.close();
    console.log("Das Programm wurde beendet.");
});
