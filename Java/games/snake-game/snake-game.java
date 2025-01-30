import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame extends JPanel implements KeyListener {
    private static final int TILE_SIZE = 20;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private LinkedList<Point> snake;
    private Point food;
    private int direction; // 0 = oben, 1 = rechts, 2 = unten, 3 = links
    private boolean gameOver;

    public SnakeGame() {
        this.snake = new LinkedList<>();
        this.snake.add(new Point(5, 5));
        this.direction = 1;
        this.gameOver = false;
        generateFood();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
        setFocusable(true);
    }

    private void generateFood() {
        Random rand = new Random();
        food = new Point(rand.nextInt(WIDTH / TILE_SIZE), rand.nextInt(HEIGHT / TILE_SIZE));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over!", 200, HEIGHT / 2);
            return;
        }

        // Hintergrund
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Schlange zeichnen
        g.setColor(Color.GREEN);
        for (Point p : snake) {
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        // Apfel zeichnen
        g.setColor(Color.RED);
        g.fillRect(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    public void move() {
        if (gameOver) return;

        Point head = snake.getFirst();
        Point newHead = new Point(head);

        switch (direction) {
            case 0: newHead.y--; break; // oben
            case 1: newHead.x++; break; // rechts
            case 2: newHead.y++; break; // unten
            case 3: newHead.x--; break; // links
        }

        // Kollisionsprüfung
        if (newHead.x < 0 || newHead.x >= WIDTH / TILE_SIZE || newHead.y < 0 || newHead.y >= HEIGHT / TILE_SIZE || snake.contains(newHead)) {
            gameOver = true;
        } else {
            snake.addFirst(newHead);

            // Wenn die Schlange den Apfel frisst
            if (newHead.equals(food)) {
                generateFood(); // neuen Apfel generieren
            } else {
                snake.removeLast(); // Entferne das letzte Segment der Schlange
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP && direction != 2) {
            direction = 0;
        } else if (key == KeyEvent.VK_RIGHT && direction != 3) {
            direction = 1;
        } else if (key == KeyEvent.VK_DOWN && direction != 0) {
            direction = 2;
        } else if (key == KeyEvent.VK_LEFT && direction != 1) {
            direction = 3;
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Spiel-Loop
        while (!game.gameOver) {
            game.move();
            game.repaint();
            try {
                Thread.sleep(100); // Spielgeschwindigkeit
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
