-- Willkommen zu meinem Haskell-Programm

main :: IO ()
main = do
    -- Begrüßung
    putStrLn "Willkommen zu meinem Haskell-Programm!"

    -- Nutzereingabe
    putStr "Bitte geben Sie Ihren Namen ein: "
    name <- getLine

    -- Begrüßung mit dem Namen
    putStrLn ("Hallo, " ++ name ++ "! Schön, dass Sie hier sind.")
    putStrLn "Das Programm wurde beendet."
