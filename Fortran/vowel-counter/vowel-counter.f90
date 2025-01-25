program vowel_counter
  implicit none
  character(len=100) :: text
  integer :: i, vowel_count
  character :: current_char

  ! Eingabe des Textes
  print*, "Gib einen Text ein, um die Anzahl der Vokale zu zählen:"
  read*, text

  ! Initialisierung der Zählvariablen
  vowel_count = 0

  ! Schleife, um durch jedes Zeichen des Textes zu gehen
  do i = 1, len(trim(adjustl(text)))
     current_char = text(i:i)
     ! Überprüfen, ob das Zeichen ein Vokal ist
     if (any(current_char == ['A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'])) then
        vowel_count = vowel_count + 1
     end if
  end do

  ! Ausgabe der Anzahl der Vokale
  print*, "Die Anzahl der Vokale im Text ist: ", vowel_count
end program vowel_counter
