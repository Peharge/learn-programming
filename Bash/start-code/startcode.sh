#!/bin/bash

# Beschreibung: Ein einfaches Bash-Skript
# Datum: 25.01.2025

# Farben für Ausgabe (optional)
RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m' # Keine Farbe

# Begrüßung
echo -e "${GREEN}Willkommen zu meinem Bash-Skript!${NC}"

# Funktion definieren
function beispiel_funktion() {
    echo "Dies ist eine Beispiel-Funktion."
}

# Hauptteil des Skripts
echo "Das Skript wird gestartet..."
beispiel_funktion

# Eingabe des Nutzers
read -p "Geben Sie einen Namen ein: " name
echo "Hallo, $name!"

# Skript beenden
echo -e "${RED}Das Skript wurde beendet.${NC}"
exit 0
