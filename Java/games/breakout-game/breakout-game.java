import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class BreakoutGame extends JPanel implements ActionListener, KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_HEIGHT = 20;
    private static final int BALL_SIZE = 15;
    private static final int BLOCK_WIDTH = 60;
    private static final int BLOCK_HEIGHT = 20;
    private static final int BLOCK_ROWS = 5;
    private static final int BLOCK_COLUMNS = 10;

    private Timer timer;
    private Rectangle paddle;
    private Rectangle ball;
    private int ballXSpeed, ballYSpeed;
    private List<Rectangle> blocks;
    private boolean leftPressed, rightPressed;

    public BreakoutGame() {
        paddle = new Rectangle(WIDTH / 2 - PADDLE_WIDTH / 2, HEIGHT - PADDLE_HEIGHT - 30, PADDLE_WIDTH, PADDLE_HEIGHT);
        ball = new Rectangle(WIDTH / 2 - BALL_SIZE / 2, HEIGHT - PADDLE_HEIGHT - BALL_SIZE - 50, BALL_SIZE, BALL_SIZE);
        ballXSpeed = 2;
        ballYSpeed = -2;
        blocks = new ArrayList<>();

        // Blöcke erzeugen
        for (int i = 0; i < BLOCK_ROWS; i++) {
            for (int j = 0; j < BLOCK_COLUMNS; j++) {
                blocks.add(new Rectangle(j * (BLOCK_WIDTH + 5) + 50, i * (BLOCK_HEIGHT + 5) + 50, BLOCK_WIDTH, BLOCK_HEIGHT));
            }
        }

        timer = new Timer(1000 / 60, this); // 60 FPS
        timer.start();

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Hintergrund
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Paddle zeichnen
        g.setColor(Color.BLUE);
        g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);

        // Ball zeichnen
        g.setColor(Color.RED);
        g.fillOval(ball.x, ball.y, ball.width, ball.height);

        // Blöcke zeichnen
        g.setColor(Color.GREEN);
        for (Rectangle block : blocks) {
            g.fillRect(block.x, block.y, block.width, block.height);
        }

        // Game Over, wenn der Ball den Boden erreicht
        if (ball.y > HEIGHT) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over!", WIDTH / 4, HEIGHT / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ball.y + ball.height > HEIGHT) {
            timer.stop();
            repaint();
            return;
        }

        // Ballbewegung
        ball.x += ballXSpeed;
        ball.y += ballYSpeed;

        // Ball prallt von den Wänden ab
        if (ball.x <= 0 || ball.x + ball.width >= WIDTH) {
            ballXSpeed = -ballXSpeed;
        }

        if (ball.y <= 0) {
            ballYSpeed = -ballYSpeed;
        }

        // Ball prallt vom Paddle ab
        if (ball.intersects(paddle)) {
            ballYSpeed = -ballYSpeed;
            ball.y = paddle.y - ball.height; // Verhindert das "Durchdringen"
        }

        // Kollision mit den Blöcken
        List<Rectangle> toRemove = new ArrayList<>();
        for (Rectangle block : blocks) {
            if (ball.intersects(block)) {
                toRemove.add(block);
                ballYSpeed = -ballYSpeed; // Ball prallt ab
                break;
            }
        }
        blocks.removeAll(toRemove);

        // Paddlebewegung
        if (leftPressed && paddle.x > 0) {
            paddle.x -= 10;
        }

        if (rightPressed && paddle.x + paddle.width < WIDTH) {
            paddle.x += 10;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout");
        BreakoutGame game = new BreakoutGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
