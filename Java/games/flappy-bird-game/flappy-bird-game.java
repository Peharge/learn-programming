import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class FlappyBirdGame extends JPanel implements ActionListener, KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BIRD_SIZE = 20;
    private static final int PIPE_WIDTH = 50;
    private static final int PIPE_GAP = 150; // Lücke zwischen den Röhren
    private static final int PIPE_SPEED = 4;
    private static final int GRAVITY = 1;
    private static final int JUMP_STRENGTH = 15;

    private Timer timer;
    private Rectangle bird;
    private List<Rectangle> pipes;
    private int birdVelocityY;
    private int score;
    private boolean gameOver;
    private boolean jumping;

    public FlappyBirdGame() {
        bird = new Rectangle(WIDTH / 4 - BIRD_SIZE / 2, HEIGHT / 2 - BIRD_SIZE / 2, BIRD_SIZE, BIRD_SIZE);
        pipes = new ArrayList<>();
        birdVelocityY = 0;
        score = 0;
        gameOver = false;
        jumping = false;

        // Initiale Röhren generieren
        generatePipes();

        timer = new Timer(1000 / 60, this); // 60 FPS
        timer.start();

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Hintergrund
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Vogel zeichnen
        g.setColor(Color.YELLOW);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);

        // Röhren zeichnen
        g.setColor(Color.GREEN);
        for (Rectangle pipe : pipes) {
            g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
        }

        // Boden zeichnen
        g.setColor(Color.GRAY);
        g.fillRect(0, HEIGHT - 50, WIDTH, 50);

        // Spielende anzeigen
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", WIDTH / 4, HEIGHT / 2);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Score: " + score, WIDTH / 3, HEIGHT / 2 + 50);
        }

        // Punktestand anzeigen
        if (!gameOver) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Score: " + score, 20, 40);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) {
            return; // Spiel stoppen
        }

        // Vogelbewegung
        if (jumping) {
            birdVelocityY = -JUMP_STRENGTH;
            jumping = false;
        }

        birdVelocityY += GRAVITY;
        bird.y += birdVelocityY;

        // Überprüfen, ob der Vogel den Boden erreicht hat
        if (bird.y + BIRD_SIZE >= HEIGHT - 50) {
            gameOver = true;
        }

        // Röhrenbewegung
        List<Rectangle> toRemove = new ArrayList<>();
        for (Rectangle pipe : pipes) {
            pipe.x -= PIPE_SPEED;
            if (pipe.x + PIPE_WIDTH < 0) {
                toRemove.add(pipe);
                score++;
            }
        }
        pipes.removeAll(toRemove);

        // Neue Röhren generieren, wenn nötig
        if (pipes.isEmpty() || pipes.get(pipes.size() - 1).x < WIDTH - 300) {
            generatePipes();
        }

        // Kollisionsprüfung
        for (Rectangle pipe : pipes) {
            if (pipe.intersects(bird)) {
                gameOver = true;
            }
        }

        repaint();
    }

    private void generatePipes() {
        int pipeHeight = (int) (Math.random() * (HEIGHT - 2 * PIPE_GAP));
        pipes.add(new Rectangle(WIDTH, 0, PIPE_WIDTH, pipeHeight)); // obere Röhre
        pipes.add(new Rectangle(WIDTH, pipeHeight + PIPE_GAP, PIPE_WIDTH, HEIGHT - pipeHeight - PIPE_GAP)); // untere Röhre
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            jumping = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        FlappyBirdGame game = new FlappyBirdGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
