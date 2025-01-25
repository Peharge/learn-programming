program sum_of_squares
  implicit none
  integer :: n, i
  integer :: sum

  ! Eingabe der Zahl n
  print*, "Gib eine Zahl ein, um die Summe der Quadrate der ersten n natürlichen Zahlen zu berechnen:"
  read*, n

  ! Initialisierung der Summe
  sum = 0

  ! Berechnung der Summe der Quadrate
  do i = 1, n
     sum = sum + i**2
  end do

  ! Ausgabe des Ergebnisses
  print*, "Die Summe der Quadrate der ersten ", n, " Zahlen ist: ", sum
end program sum_of_squares
