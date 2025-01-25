use std::io::{self, Write};
use rand::Rng;

fn main() {
    // Zufallszahl zwischen 1 und 100 generieren
    let secret_number = rand::thread_rng().gen_range(1..=100);
    println!("Willkommen zum Zahlenratespiel!");
    println!("Ich habe eine Zahl zwischen 1 und 100 gewählt. Kannst du sie erraten?");

    loop {
        print!("Bitte gib deine Schätzung ein: ");
        io::stdout().flush().unwrap();  // Um die Eingabeaufforderung sofort anzuzeigen

        let mut guess = String::new();
        io::stdin().read_line(&mut guess).unwrap();

        // Versuchen, die Eingabe in eine Zahl zu parsen
        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => {
                println!("Das ist keine gültige Zahl. Bitte versuche es erneut.");
                continue;
            }
        };

        // Überprüfen, ob die Zahl korrekt ist
        if guess < secret_number {
            println!("Zu niedrig! Versuche es noch einmal.");
        } else if guess > secret_number {
            println!("Zu hoch! Versuche es noch einmal.");
        } else {
            println!("Glückwunsch! Du hast die Zahl {} erraten.", secret_number);
            break;  // Spiel beenden
        }
    }
}
