import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TetrisGame extends JPanel implements KeyListener {
    private static final int TILE_SIZE = 30; // Größe eines Blocks
    private static final int WIDTH = 10; // Breite des Spielfelds (10 Spalten)
    private static final int HEIGHT = 20; // Höhe des Spielfelds (20 Reihen)
    private int[][] field; // Spielfeld (2D-Array)
    private Tetromino currentTetromino; // Der aktuelle Block
    private boolean gameOver; // Spielstatus
    private Timer timer;

    public TetrisGame() {
        this.field = new int[HEIGHT][WIDTH];
        this.currentTetromino = generateTetromino();
        this.gameOver = false;
        this.timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameOver) {
                    moveTetrominoDown();
                    repaint();
                }
            }
        });
        this.timer.start();
        setPreferredSize(new Dimension(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE));
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Spielfeld zeichnen
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (field[row][col] != 0) {
                    g.setColor(new Color(0, 0, 255)); // Blockfarbe
                    g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE); // Blockrahmen
                }
            }
        }

        // Der aktuelle Tetrimino zeichnen
        if (currentTetromino != null) {
            g.setColor(new Color(255, 0, 0)); // Tetrimino-Farbe
            for (Point p : currentTetromino.getShape()) {
                g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE); // Blockrahmen
            }
        }

        // Game Over anzeigen
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over!", 100, HEIGHT * TILE_SIZE / 2);
        }
    }

    // Tetriminos bewegen
    public void moveTetrominoDown() {
        // Verschiebe den Tetrimino nach unten, wenn es noch Platz gibt
        for (Point p : currentTetromino.getShape()) {
            if (p.y + 1 >= HEIGHT || field[p.y + 1][p.x] != 0) {
                placeTetromino(); // Setze Tetrimino im Spielfeld
                currentTetromino = generateTetromino(); // Generiere einen neuen Tetrimino
                if (!canMoveTetromino(currentTetromino, currentTetromino.getShape()[0].x, currentTetromino.getShape()[0].y)) {
                    gameOver = true; // Spiel vorbei, wenn der Tetrimino nicht passt
                }
                return;
            }
        }
        currentTetromino.move(0, 1); // Bewege Tetrimino nach unten
    }

    public boolean canMoveTetromino(Tetromino t, int x, int y) {
        for (Point p : t.getShape()) {
            int newX = p.x + x;
            int newY = p.y + y;
            if (newX < 0 || newX >= WIDTH || newY < 0 || newY >= HEIGHT || field[newY][newX] != 0) {
                return false;
            }
        }
        return true;
    }

    public void placeTetromino() {
        for (Point p : currentTetromino.getShape()) {
            field[p.y][p.x] = 1; // Setze den Block im Spielfeld
        }
    }

    public Tetromino generateTetromino() {
        Random rand = new Random();
        int randomShape = rand.nextInt(7);
        switch (randomShape) {
            case 0: return new Tetromino(new Point(4, 0), Tetromino.Shape.I);
            case 1: return new Tetromino(new Point(4, 0), Tetromino.Shape.O);
            case 2: return new Tetromino(new Point(4, 0), Tetromino.Shape.T);
            case 3: return new Tetromino(new Point(4, 0), Tetromino.Shape.S);
            case 4: return new Tetromino(new Point(4, 0), Tetromino.Shape.Z);
            case 5: return new Tetromino(new Point(4, 0), Tetromino.Shape.J);
            case 6: return new Tetromino(new Point(4, 0), Tetromino.Shape.L);
            default: return null;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver) return;

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            if (canMoveTetromino(currentTetromino, currentTetromino.getShape()[0].x - 1, currentTetromino.getShape()[0].y)) {
                currentTetromino.move(-1, 0);
            }
        } else if (key == KeyEvent.VK_RIGHT) {
            if (canMoveTetromino(currentTetromino, currentTetromino.getShape()[0].x + 1, currentTetromino.getShape()[0].y)) {
                currentTetromino.move(1, 0);
            }
        } else if (key == KeyEvent.VK_DOWN) {
            moveTetrominoDown();
        } else if (key == KeyEvent.VK_UP) {
            currentTetromino.rotate();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris");
        TetrisGame game = new TetrisGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
