program reverse_number
  implicit none
  integer :: num, reversed, remainder

  ! Eingabe der Zahl
  print*, "Gib eine Zahl ein, die umgekehrt werden soll:"
  read*, num

  ! Initialisierung der Variablen
  reversed = 0
  remainder = 0

  ! Schleife, um die Ziffern zu extrahieren und umzukehren
  do while (num /= 0)
     remainder = mod(num, 10)   ! letzte Ziffer
     reversed = reversed * 10 + remainder   ! Umkehrung der Ziffern
     num = num / 10   ! entferne die letzte Ziffer
  end do

  ! Ausgabe der umgekehrten Zahl
  print*, "Die umgekehrte Zahl ist: ", reversed
end program reverse_number
