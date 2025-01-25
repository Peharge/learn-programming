# Beschreibung: Ein einfaches R-Programm
# Datum: 25.01.2025

# Begrüßung
cat("Willkommen zu meinem R-Programm!\n")

# Funktion definieren
begruessung <- function() {
  cat("Das ist eine Beispiel-Funktion in R.\n")
}

# Funktion aufrufen
begruessung()

# Nutzereingabe
name <- readline(prompt = "Bitte geben Sie Ihren Namen ein: ")

# Begrüßung mit dem Namen
cat("Hallo, ", name, "! Schön, dass Sie hier sind.\n", sep="")

# Programm beenden
cat("Das Programm wurde beendet.\n")
