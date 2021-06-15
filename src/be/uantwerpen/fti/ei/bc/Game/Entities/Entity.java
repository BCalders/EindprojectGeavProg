package be.uantwerpen.fti.ei.bc.Game.Entities;

import java.awt.*;

public abstract class Entity {

    //pos and vect
    protected double x, y;
    protected double dx, dy;

    //dimensions
    protected int width, height;

    //collision box
    protected int cWidth, cHeight;
    protected boolean isTopLeft, isTopRight, isBottomLeft, isBottomRight;

    //movement
    protected boolean left, right, up, down;

    //movement attributes
    protected double moveSpeed, maxSpeed, stopSpeed;

    public Entity() {

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getcWidth() {
        return cWidth;
    }

    public int getcHeight() {
        return cHeight;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public Rectangle getRectangle() {
        return new Rectangle((int) x + cWidth, (int) y + cHeight, cWidth, cHeight);
    }

    public boolean intersects(Entity other) {
        Rectangle r1 = getRectangle();
        Rectangle r2 = other.getRectangle();
        return r1.intersects(r2);
    }


}
