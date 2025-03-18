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
        body.add(new Position(90, 100));
        body.add(new Position(80, 100));
        body.add(new Position(70, 100));
        body.add(new Position(60, 100));
        body.add(new Position(50, 100));
        body.add(new Position(40, 100));
        direction = Direction.right;
        this.tileSize = tileSize;
    }
    public void changeDirection(Direction dir) {
        direction = dir;
    }
    public void grow() {
        Position head = body.getFirst();
        switch (direction) {
            case Direction.right -> body.addFirst(new Position(head.x + tileSize, head.y));
            case Direction.left -> body.addFirst(new Position(head.x - tileSize, head.y));
            case Direction.up -> body.addFirst(new Position(head.x, head.y + tileSize));
            case Direction.down -> body.addFirst(new Position(head.x, head.y - tileSize));
        }
    }
    public void move() {
        for (int i = body.size()-1; i > 0; i--) {
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