# Beschreibung: Ein einfaches PowerShell-Skript
# Datum: 25.01.2025

# Begrüßung
Write-Host "Willkommen zu meinem PowerShell-Programm!" -ForegroundColor Green

# Funktion definieren
function Begruessung {
    Write-Host "Das ist eine Beispiel-Funktion in PowerShell." -ForegroundColor Cyan
}

# Funktion aufrufen
Begruessung

# Nutzereingabe
$name = Read-Host "Bitte geben Sie Ihren Namen ein"

# Begrüßung mit dem Namen
Write-Host "Hallo, $name! Schön, dass Sie hier sind." -ForegroundColor Yellow

# Programm beenden
Write-Host "Das Programm wurde beendet." -ForegroundColor Red
