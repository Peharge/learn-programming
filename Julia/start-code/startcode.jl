# Beschreibung: Ein einfaches Julia-Programm
# Datum: 25.01.2025

# Begrüßung
println("Willkommen zu meinem Julia-Programm!")

# Funktion definieren
function begruessung()
    println("Das ist eine Beispiel-Funktion in Julia.")
end

# Funktion aufrufen
begruessung()

# Nutzereingabe
print("Bitte geben Sie Ihren Namen ein: ")
name = readline() # Liest eine Eingabe von der Konsole

# Begrüßung mit dem Namen
println("Hallo, $name! Schön, dass Sie hier sind.")

# Programm beenden
println("Das Programm wurde beendet.")
