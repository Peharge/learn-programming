program simple_calculator
  implicit none
  real :: num1, num2, result
  integer :: choice

  ! Begrüßung
  print*, "Willkommen beim einfachen Taschenrechner!"

  ! Endlosschleife für wiederholte Berechnungen
  do
     ! Benutzeranweisung
     print*, "Wählen Sie eine Operation:"
     print*, "1. Addition"
     print*, "2. Subtraktion"
     print*, "3. Multiplikation"
     print*, "4. Division"
     print*, "5. Beenden"

     ! Eingabe der Wahl
     read*, choice

     ! Verarbeiten der Auswahl
     if (choice == 5) then
        print*, "Taschenrechner wird beendet."
        exit
     endif

     print*, "Gib die erste Zahl ein:"
     read*, num1
     print*, "Gib die zweite Zahl ein:"
     read*, num2

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
     case default
        print*, "Ungültige Auswahl. Bitte wählen Sie eine gültige Option."
     end select

  end do
end program simple_calculator
