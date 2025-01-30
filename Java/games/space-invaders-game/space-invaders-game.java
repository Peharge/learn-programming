import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends JPanel implements KeyListener, ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int SHIP_SPEED = 5;
    private static final int BULLET_SPEED = 10;
    private static final int ALIEN_SPEED = 1;

    private Rectangle ship;
    private List<Rectangle> bullets;
    private List<Rectangle> aliens;
    private boolean leftPressed, rightPressed, shootPressed;
    private Timer timer;
    private boolean gameOver;

    public SpaceInvadersGame() {
        ship = new Rectangle(WIDTH / 2 - 25, HEIGHT - 50, 50, 30); // Raumschiff
        bullets = new ArrayList<>();
        aliens = new ArrayList<>();
        gameOver = false;

        // Aliens generieren
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                aliens.add(new Rectangle(j * 60 + 50, i * 40 + 50, 50, 30)); // Aliengröße und Abstand
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

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over!", WIDTH / 4, HEIGHT / 2);
            return;
        }

        // Hintergrund
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Raumschiff zeichnen
        g.setColor(Color.GREEN);
        g.fillRect(ship.x, ship.y, ship.width, ship.height);

        // Schüsse zeichnen
        g.setColor(Color.YELLOW);
        for (Rectangle bullet : bullets) {
            g.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
        }

        // Aliens zeichnen
        g.setColor(Color.RED);
        for (Rectangle alien : aliens) {
            g.fillRect(alien.x, alien.y, alien.width, alien.height);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        // Bewegung des Raumschiffs
        if (leftPressed && ship.x > 0) {
            ship.x -= SHIP_SPEED;
        }
        if (rightPressed && ship.x < WIDTH - ship.width) {
            ship.x += SHIP_SPEED;
        }

        // Bewegung der Schüsse
        List<Rectangle> toRemove = new ArrayList<>();
        for (Rectangle bullet : bullets) {
            bullet.y -= BULLET_SPEED;
            if (bullet.y < 0) {
                toRemove.add(bullet);
            }
        }
        bullets.removeAll(toRemove);

        // Kollisionsprüfungen (Schüsse treffen Aliens)
        for (Rectangle bullet : bullets) {
            for (Rectangle alien : aliens) {
                if (bullet.intersects(alien)) {
                    aliens.remove(alien);
                    bullets.remove(bullet);
                    break;
                }
            }
        }

        // Bewegung der Aliens
        for (Rectangle alien : aliens) {
            alien.y += ALIEN_SPEED;
            if (alien.y > HEIGHT - 50) {
                gameOver = true;
            }
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
        } else if (key == KeyEvent.VK_SPACE) {
            if (!shootPressed) {
                bullets.add(new Rectangle(ship.x + ship.width / 2 - 5, ship.y, 10, 20));
                shootPressed = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        } else if (key == KeyEvent.VK_SPACE) {
            shootPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Invaders");
        SpaceInvadersGame game = new SpaceInvadersGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
