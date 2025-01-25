use std::io::{self, Write};

#[derive(Copy, Clone, PartialEq)]
enum Player {
    X,
    O,
}

#[derive(Copy, Clone)]
struct Game {
    board: [char; 9],
    current_player: Player,
}

impl Game {
    fn new() -> Self {
        Game {
            board: [' '; 9],
            current_player: Player::X,
        }
    }

    fn print_board(&self) {
        println!();
        for i in 0..3 {
            println!(
                " {} | {} | {} ",
                self.board[i * 3],
                self.board[i * 3 + 1],
                self.board[i * 3 + 2]
            );
            if i < 2 {
                println!("---+---+---");
            }
        }
        println!();
    }

    fn play_turn(&mut self, position: usize) {
        if self.board[position] == ' ' {
            self.board[position] = match self.current_player {
                Player::X => 'X',
                Player::O => 'O',
            };
            self.current_player = match self.current_player {
                Player::X => Player::O,
                Player::O => Player::X,
            };
        }
    }

    fn is_winner(&self) -> Option<Player> {
        let win_combinations = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6],
        ];

        for combination in win_combinations.iter() {
            let [a, b, c] = *combination;
            if self.board[a] == self.board[b] && self.board[b] == self.board[c] && self.board[a] != ' ' {
                return Some(match self.board[a] {
                    'X' => Player::X,
                    'O' => Player::O,
                    _ => unreachable!(),
                });
            }
        }
        None
    }

    fn is_draw(&self) -> bool {
        !self.board.contains(&' ') && self.is_winner().is_none()
    }
}

fn main() {
    let mut game = Game::new();
    loop {
        game.print_board();
        println!("Spieler {:?}, gib deine Position (0-8) ein:", game.current_player);

        let mut input = String::new();
        io::stdout().flush().unwrap();
        io::stdin().read_line(&mut input).unwrap();

        let position: usize = match input.trim().parse() {
            Ok(num) if num >= 0 && num < 9 => num,
            _ => {
                println!("Ungültige Eingabe, bitte versuche es erneut.");
                continue;
            }
        };

        game.play_turn(position);

        if let Some(winner) = game.is_winner() {
            game.print_board();
            println!("Spieler {:?} gewinnt!", winner);
            break;
        } else if game.is_draw() {
            game.print_board();
            println!("Das Spiel endet unentschieden!");
            break;
        }
    }
}
