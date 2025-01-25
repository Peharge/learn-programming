// Beschreibung: Ein einfaches Rust-Programm
// Datum: 25.01.2025

use std::io;

fn main() {
    // Begrüßung
    println!("Willkommen zu meinem Rust-Programm!");

    // Nutzereingabe
    println!("Bitte geben Sie Ihren Namen ein:");

    let mut name = String::new();
    io::stdin()
        .read_line(&mut name)
        .expect("Fehler beim Lesen der Eingabe");

    // Entfernen des Zeilenumbruchs am Ende der Eingabe
    let name = name.trim();

    // Begrüßung mit dem Namen
    println!("Hallo, {}! Schön, dass Sie hier sind.", name);

    // Programm beenden
    println!("Das Programm wurde beendet.");
}
