import java.util.ArrayList;
import java.util.List;

public class Snake {
    int speed = 1;
    int tileSize;
    List<Position> body = new ArrayList<>();
    Direction direction;
    Snake(int tileSize) {
        body.add(new Position(120, 100));
        body.add(new Position(110, 100));
        body.add(new Position(100, 100));
        direction = Direction.right;
        this.tileSize = tileSize;
    }
    public void changeDirection(Direction dir) {
        direction = dir;
    }
    public void grow() {
        switch (direction) {
            case Direction.right -> body.add(new Position(body.getLast().x - tileSize, body.getLast().y));
            case Direction.left -> body.add(new Position(body.getLast().x + tileSize, body.getLast().y));
            case Direction.up -> body.add(new Position(body.getLast().x, body.getLast().y - tileSize));
            case Direction.down -> body.add(new Position(body.getLast().x, body.getLast().y + tileSize));
        }
    }
    public void move() {
        for (int i = 1; i < body.size(); i++) {
            body.set(i, body.get(i-1));
        }
        switch (direction) {
            case Direction.right -> body.set(0, new Position(body.getFirst().x + speed*tileSize, body.getFirst().y));
            case Direction.left -> body.set(0, new Position(body.getFirst().x - speed*tileSize, body.getFirst().y));
            case Direction.up -> body.set(0, new Position(body.getFirst().x, body.getFirst().y - speed*tileSize));
            case Direction.down -> body.set(0, new Position(body.getFirst().x, body.getFirst().y + speed*tileSize));
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
    }
}