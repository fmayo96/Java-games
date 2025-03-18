import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
    int width = 600;
    int height = 600;
    int tileSize = 10;
    int score;
    Snake snake;
    Food food;
    Timer gameLoop;
    SnakeGame() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(this);
        score = 0;
        snake = new Snake(tileSize);
        food = new Food(width, height, tileSize);
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                if (snake.direction != Direction.right) snake.changeDirection(Direction.left);
            }
            case KeyEvent.VK_RIGHT -> {
                if (snake.direction != Direction.left) snake.changeDirection(Direction.right);
            }
            case KeyEvent.VK_UP -> {
                if (snake.direction != Direction.down) snake.changeDirection(Direction.up);
            }
            case KeyEvent.VK_DOWN -> {
                if (snake.direction != Direction.up) snake.changeDirection(Direction.down);
            }
            default -> throw new IllegalStateException("Unexpected value: " + e.getKeyCode());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        for (Position pos: snake.body) {
            g.fillRect(pos.x, pos.y, tileSize, tileSize);
        }
        g.setColor(Color.red);
        g.fillRect(food.x, food.y,
                tileSize, tileSize);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        g.drawString("Score: ".concat(String.valueOf(score)), 20, 50);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        checkFoodCollision();
        checkWallCollision();
        checkSnakeCollision();
        snake.move();
        repaint();
    }

    public void checkFoodCollision() {
        Position head = snake.body.getFirst();
        if (((head.x+tileSize) > food.x) && (head.x < (food.x + tileSize))) {
            if (((head.y+tileSize) > food.y) && (head.y < (food.y + tileSize))) {
                food.replace();
                snake.grow();
                score++;
            }
        }
    }

    public void checkWallCollision() {
        Position head = snake.body.getFirst();
        if (head.x >= width || head.x <= 0 || head.y <= 0 || head.y >= height) {
            gameLoop.stop();
        }
    }

    public void checkSnakeCollision() {
        Position head = snake.body.getFirst();
        for (int i = 1; i < snake.body.size(); i++) {
            Position tile = snake.body.get(i);
        }
    }
 }
