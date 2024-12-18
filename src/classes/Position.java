package classes;

public class Position {
    public int x;
    public int y;
    public Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toHashValue() {
        return this.x + "-" + this.y;
    }

    public String toDirectionHashValue() {
        return this.x + "-" + this.y + "-" + this.direction;
    }

    public String toString() {
        return "Position: (" + this.x + ", " + this.y + ")    Direction: " + this.direction;
    }
}
