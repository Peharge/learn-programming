import 'dart:io';

void main() {
  // Begrüßung
  print('Willkommen zu meinem Dart-Programm!');

  // Nutzereingabe
  stdout.write('Bitte geben Sie Ihren Namen ein: ');
  String name = stdin.readLineSync() ?? ''; // Liest die Eingabe des Nutzers

  // Begrüßung mit dem Namen
  print('Hallo, $name! Schön, dass Sie hier sind.');

  // Programm beenden
  print('Das Programm wurde beendet.');
}
