const std = @import("std");

pub fn main() void {
    // Begrüßung
    std.debug.print("Willkommen zu meinem Zig-Programm!\n", .{});

    // Nutzereingabe
    std.debug.print("Bitte geben Sie Ihren Namen ein: ");
    var name = try std.io.getStdIn().readLineAlloc(std.heap.page_allocator);

    // Begrüßung mit dem Namen
    std.debug.print("Hallo, {}! Schön, dass Sie hier sind.\n", .{name});
    std.debug.print("Das Programm wurde beendet.\n", .{});
}
