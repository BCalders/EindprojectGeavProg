package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class PlayerShip extends Entity {

    protected boolean isShooting = false;
    protected int shootingCooldown;

    public PlayerShip() {
        this.width = 2;
        this.height = 2;
        cWidth = width;
        cHeight = height;
        speed = 0.2;
    }

    public void update() {

        double xTemp = x + dx;

        if (dx < 0) {
            if (xTemp < -30){
                dx = 0;
                x = -30;
            }else
                x = xTemp;
        }
        if (dx > 0) {
            if (xTemp > 30-cWidth){
                dx = 0;
                x = 30-cWidth;
            }else
                x = xTemp;
        }
    }

    public abstract void draw();

    public void shoot() {
        System.out.println("PLAYER SHOOT");
        isShooting = true;
    }
}