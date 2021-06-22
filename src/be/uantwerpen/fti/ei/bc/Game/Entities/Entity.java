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

    protected double speed;

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

    public double getSpeed() {
        return speed;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public boolean intersects(Entity o) {

        return (x < o.x + o.cWidth) && (o.x < x + cWidth) && (y < o.y + cHeight) && (o.y < y + cHeight) ;
    }

}
