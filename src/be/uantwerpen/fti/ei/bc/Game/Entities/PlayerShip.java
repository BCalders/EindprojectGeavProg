package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class PlayerShip extends Entity {

    protected boolean isShooting = false;
    protected int shootingCooldown;

    public PlayerShip() {
        this.width = 0.2;
        this.height = 0.2;
        cWidth = width;
        cHeight = height;
        speed = 0.05;
    }

    public void update() {

        double xTemp = x + dx;

        if (dx < 0) {
            if (xTemp < -3) {
                dx = 0;
                x = -3;
            } else
                x = xTemp;
        }
        if (dx > 0) {
            if (xTemp > 3 - cWidth) {
                dx = 0;
                x = 3 - cWidth;
            } else
                x = xTemp;
        }
    }

    public abstract void draw();

    public void shoot() {
        System.out.println("PLAYER SHOOT");
        isShooting = true;
    }
}