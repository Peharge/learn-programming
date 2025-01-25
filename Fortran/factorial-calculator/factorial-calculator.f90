program factorial
  implicit none
  integer :: n, i
  integer :: result

  ! Eingabe der Zahl, deren Fakultät berechnet werden soll
  print*, "Gib eine Zahl ein, um ihre Fakultät zu berechnen:"
  read*, n

  ! Initialisierung des Ergebnisses
  result = 1

  ! Berechnung der Fakultät
  do i = 1, n
     result = result * i
  end do

  ! Ausgabe des Ergebnisses
  print*, "Die Fakultät von ", n, " ist ", result
end program factorial
