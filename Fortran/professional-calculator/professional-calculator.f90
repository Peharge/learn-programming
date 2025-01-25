program professional_calculator
  implicit none
  real :: num1, num2, result
  integer :: choice
  character(len=10) :: operation

  ! Begrüßung
  print*, "Willkommen beim professionellen Taschenrechner!"
  print*, "Unterstützte Funktionen: Addition, Subtraktion, Multiplikation, Division,"
  print*, "Potenzen, Quadratwurzeln, Trigonometrie (Sinus, Cosinus, Tangens), Logarithmen."

  ! Endlosschleife für wiederholte Berechnungen
  do
     ! Benutzeranweisung
     print*, "Wählen Sie eine Operation:"
     print*, "1. Addition"
     print*, "2. Subtraktion"
     print*, "3. Multiplikation"
     print*, "4. Division"
     print*, "5. Potenzierung (x^y)"
     print*, "6. Quadratwurzel (sqrt(x))"
     print*, "7. Sinus (sin(x))"
     print*, "8. Cosinus (cos(x))"
     print*, "9. Tangens (tan(x))"
     print*, "10. Logarithmus (log(x))"
     print*, "11. Beenden"

     ! Eingabe der Wahl
     read*, choice

     ! Verarbeiten der Auswahl
     if (choice == 11) then
        print*, "Taschenrechner wird beendet."
        exit
     endif

     ! Benutzereingaben
     if (choice /= 6 .and. choice /= 7 .and. choice /= 8 .and. choice /= 9 .and. choice /= 10) then
        print*, "Gib die erste Zahl ein:"
        read*, num1
     endif
     if (choice == 5 .or. choice == 1 .or. choice == 2 .or. choice == 3 .or. choice == 4 .or. choice == 5) then
        print*, "Gib die zweite Zahl ein:"
        read*, num2
     end if

     ! Auswahl der Operation und Berechnung
     select case(choice)
     case(1)
        result = num1 + num2
        print*, "Ergebnis der Addition: ", result
     case(2)
        result = num1 - num2
        print*, "Ergebnis der Subtraktion: ", result
     case(3)
        result = num1 * num2
        print*, "Ergebnis der Multiplikation: ", result
     case(4)
        if (num2 == 0) then
           print*, "Fehler: Division durch Null ist nicht erlaubt!"
        else
           result = num1 / num2
           print*, "Ergebnis der Division: ", result
        end if
     case(5)
        result = num1 ** num2
        print*, "Ergebnis der Potenzierung: ", result
     case(6)
        if (num1 < 0) then
           print*, "Fehler: Quadratwurzel einer negativen Zahl ist nicht definiert!"
        else
           result = sqrt(num1)
           print*, "Ergebnis der Quadratwurzel: ", result
        end if
     case(7)
        result = sin(num1)
        print*, "Ergebnis des Sinus: ", result
     case(8)
        result = cos(num1)
        print*, "Ergebnis des Cosinus: ", result
     case(9)
        result = tan(num1)
        print*, "Ergebnis des Tangens: ", result
     case(10)
        if (num1 <= 0) then
           print*, "Fehler: Der Logarithmus einer nicht positiven Zahl ist nicht definiert!"
        else
           result = log(num1)
           print*, "Ergebnis des Logarithmus: ", result
        end if
     case default
        print*, "Ungültige Auswahl. Bitte wählen Sie eine gültige Option."
     end select

  end do
end program professional_calculator
