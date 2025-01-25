program startcode
    implicit none
    character(30) :: name

    ! Begrüßung
    print *, 'Willkommen zu meinem Fortran-Programm!'

    ! Nutzereingabe
    print *, 'Bitte geben Sie Ihren Namen ein: '
    read *, name

    ! Begrüßung mit dem Namen
    print *, 'Hallo, ', trim(adjustl(name)), '! Schön, dass Sie hier sind.'
    print *, 'Das Programm wurde beendet.'
end program startcode
