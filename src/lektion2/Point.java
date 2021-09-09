package lektion2;

public class Point {

    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }

    public void setNew(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Point p) {
        return x == p.x &&
                y == p.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }
}
