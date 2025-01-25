# Willkommen zu meinem Nim-Programm

import strutils

proc startCode() =
  echo "Willkommen zu meinem Nim-Programm!"
  echo "Bitte geben Sie Ihren Namen ein: "
  let name = readLine(stdin)
  echo "Hallo, ", name.strip(), "! Schön, dass Sie hier sind."
  echo "Das Programm wurde beendet."

startCode()
