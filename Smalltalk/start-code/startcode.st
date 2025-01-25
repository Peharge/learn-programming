"Willkommen zu meinem Smalltalk-Programm"

| name |

Transcript show: 'Willkommen zu meinem Smalltalk-Programm!'; cr.
Transcript show: 'Bitte geben Sie Ihren Namen ein: '; flush.
name := FileStream stdin nextLine.
Transcript show: 'Hallo, ', name, '! Schön, dass Sie hier sind.'; cr.
Transcript show: 'Das Programm wurde beendet.'; cr.
