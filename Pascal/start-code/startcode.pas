program StartCode;

uses
  crt;

var
  name: string;

begin
  clrscr;  { Bildschirm löschen }
  writeln('Willkommen zu meinem Pascal-Programm!');
  write('Bitte geben Sie Ihren Namen ein: ');
  readln(name);
  writeln('Hallo, ', name, '! Schön, dass Sie hier sind.');
  writeln('Das Programm wurde beendet.');
end.
