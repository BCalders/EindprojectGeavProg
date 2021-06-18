package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class PlayerShip extends Entity {

    public PlayerShip() {
        this.width = 2;
        this.height = 2;
        cWidth = width;
        cHeight = height;
        speed = 0.2;
    }

    public void update() {
        double xTemp, yTemp;

        xTemp = (x + dx);
        yTemp = (y + dy);


        if (xTemp <= -30 || xTemp >= (30-cWidth)) {
            dx = 0;
        } else
            x = xTemp;
        if (yTemp <= -40 || yTemp >= (40-cHeight)) {
            dy = 0;
        } else
            y = yTemp;
    }

    public abstract void draw();

    public void shoot(){
        System.out.println("PLAYER SHOOT");
    }
}
