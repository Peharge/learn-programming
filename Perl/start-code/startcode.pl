#!/usr/bin/perl
# Beschreibung: Ein einfaches Perl-Programm
# Datum: 25.01.2025

use strict;
use warnings;

# Begrüßung
print "Willkommen zu meinem Perl-Programm!\n";

# Funktion definieren
sub begruessung {
    print "Das ist eine Beispiel-Funktion in Perl.\n";
}

# Funktion aufrufen
begruessung();

# Nutzereingabe
print "Bitte geben Sie Ihren Namen ein: ";
my $name = <STDIN>;
chomp($name);  # Entfernt den Zeilenumbruch am Ende der Eingabe

# Begrüßung mit dem Namen
print "Hallo, $name! Schön, dass Sie hier sind.\n";

# Programm beenden
print "Das Programm wurde beendet.\n";
