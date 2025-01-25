class StartCode {
    static function main() {
        // Begrüßung
        trace("Willkommen zu meinem Haxe-Programm!");

        // Nutzereingabe
        var name:String = sys.io.stdin().readLine();

        // Begrüßung mit dem Namen
        trace("Hallo, " + name + "! Schön, dass Sie hier sind.");
        trace("Das Programm wurde beendet.");
    }
}
