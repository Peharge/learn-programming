<?php
// Beschreibung: Ein einfaches PHP-Programm
// Datum: 25.01.2025

// Begrüßung
echo "Willkommen zu meinem PHP-Programm!\n";

// Funktion definieren
function begruessung() {
    echo "Das ist eine Beispiel-Funktion in PHP.\n";
}

// Funktion aufrufen
begruessung();

// Nutzereingabe
echo "Bitte geben Sie Ihren Namen ein: ";
$name = trim(fgets(STDIN)); // Liest eine Eingabe von der Konsole

// Begrüßung mit dem Namen
echo "Hallo, $name! Schön, dass Sie hier sind.\n";

// Programm beenden
echo "Das Programm wurde beendet.\n";
?>
