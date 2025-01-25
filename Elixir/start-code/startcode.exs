# Willkommen zu meinem Elixir-Programm

IO.puts "Willkommen zu meinem Elixir-Programm!"

IO.write "Bitte geben Sie Ihren Namen ein: "
name = IO.gets("") |> String.trim()  # Liest die Eingabe des Nutzers

IO.puts "Hallo, #{name}! Schön, dass Sie hier sind."
IO.puts "Das Programm wurde beendet."
