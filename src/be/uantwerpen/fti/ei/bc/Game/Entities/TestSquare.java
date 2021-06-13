package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class TestSquare {

    private int x, y;
    private double dx, dy;

    public TestSquare(int x, int y, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
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

    public double getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }
    public double getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void update(){
        x+=dx;
        y+=dy;
    }

    public abstract void draw();

}
