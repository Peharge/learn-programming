program prime_numbers
  implicit none
  integer :: n, i, j
  logical :: is_prime

  ! Eingabe der maximalen Zahl
  print*, "Gib eine Zahl ein, bis zu der Primzahlen berechnet werden sollen:"
  read*, n

  print*, "Die Primzahlen bis ", n, " sind:"

  ! Schleife, um alle Zahlen bis n zu überprüfen
  do i = 2, n
     is_prime = .true.

     ! Überprüfung, ob i eine Primzahl ist
     do j = 2, i-1
        if (mod(i, j) == 0) then
           is_prime = .false.
           exit
        end if
     end do

     ! Wenn die Zahl eine Primzahl ist, ausgeben
     if (is_prime) then
        print*, i
     end if
  end do
end program prime_numbers
