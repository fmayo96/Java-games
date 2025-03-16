import java.util.Random;

public class Food {
    int x;
    int y;
    int tileSize;
    int width;
    int height;
    Food(int width, int height, int tileSize) {
        this.width = width;
        this.height = height;
        this.tileSize = tileSize;
        x = new Random().nextInt(tileSize, width - tileSize);
        y = new Random().nextInt(tileSize, height - tileSize);
    }
    public void replace() {
        x = new Random().nextInt(tileSize, width - tileSize);
        y = new Random().nextInt(tileSize, height - tileSize);
    }
}