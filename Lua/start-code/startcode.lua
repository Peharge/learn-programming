-- Beschreibung: Ein einfaches Lua-Programm
-- Datum: 25.01.2025

-- Begrüßung
print("Willkommen zu meinem Lua-Programm!")

-- Funktion definieren
function begruessung()
    print("Das ist eine Beispiel-Funktion in Lua.")
end

-- Funktion aufrufen
begruessung()

-- Nutzereingabe
io.write("Bitte geben Sie Ihren Namen ein: ")
local name = io.read() -- Liest eine Eingabe von der Konsole

-- Begrüßung mit dem Namen
print("Hallo, " .. name .. "! Schön, dass Sie hier sind.")

-- Programm beenden
print("Das Programm wurde beendet.")
