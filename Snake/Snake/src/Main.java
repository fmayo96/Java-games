import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SnakeGame snakeGame = new SnakeGame();
        URL imgURL = Main.class.getResource("./snake_icon.png");
        if (imgURL != null) {
            ImageIcon img = new ImageIcon(imgURL);
            frame.setIconImage(img.getImage());
        }
        frame.add(snakeGame);
        snakeGame.requestFocus();
        frame.pack();
    }
}