
package simplegame;

public abstract class Position {
    private int x;
    private int y;
    public int speed;
    public String ch;
    public abstract void draw();

    public String getCh() {
        return ch;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }
}
