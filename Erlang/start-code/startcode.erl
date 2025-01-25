-module(startcode).
-export([start/0]).

start() ->
    io:format("Willkommen zu meinem Erlang-Programm!~n"),
    io:format("Bitte geben Sie Ihren Namen ein: "),
    Name = io:get_line(""),
    NameTrimmed = string:strip(Name),
    io:format("Hallo, ~s! Schön, dass Sie hier sind.~n", [NameTrimmed]),
    io:format("Das Programm wurde beendet.~n").
