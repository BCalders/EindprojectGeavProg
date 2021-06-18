package be.uantwerpen.fti.ei.bc.Game.Entities;

import java.awt.*;

public abstract class Entity {

    //pos and vect
    protected double x, y;
    protected double dx, dy;

    //dimensions
    protected double width, height;

    //collision box
    protected double cWidth, cHeight;

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

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getcWidth() {
        return cWidth;
    }

    public double getcHeight() {
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
        return new Rectangle((int) x + (int) cWidth, (int) y + (int) cHeight, (int)cWidth, (int)cHeight);
    }

    public boolean intersects(Entity other) {
        Rectangle r1 = getRectangle();
        Rectangle r2 = other.getRectangle();
        return r1.intersects(r2);
    }


}
