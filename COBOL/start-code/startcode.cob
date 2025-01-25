       IDENTIFICATION DIVISION.
       PROGRAM-ID. Startcode.

       ENVIRONMENT DIVISION.

       DATA DIVISION.

       WORKING-STORAGE SECTION.
       01 Name PIC A(30).

       PROCEDURE DIVISION.

       DISPLAY "Willkommen zu meinem COBOL-Programm!".
       DISPLAY "Bitte geben Sie Ihren Namen ein: ".
       ACCEPT Name.
       DISPLAY "Hallo, " Name " ! Schön, dass Sie hier sind.".
       DISPLAY "Das Programm wurde beendet.".

       STOP RUN.
