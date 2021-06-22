package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class EnemyShip extends Entity {

    protected boolean isDead;

    public EnemyShip() {
        this.width = 0.3;
        this.height = 0.3;
        cHeight = 0.3;
        cWidth = 0.3;
        isDead = false;
        speed = 0.02;
    }

    public boolean shouldRemove() {
        return isDead;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void kill() {
        isDead = true;
    }

    public void update() {
        x += dx * speed;
    }

    public boolean detectEdge() {
        double xTemp = x + dx * speed;
        if (dx < 0) {
            if (xTemp < -3 - (width - cWidth) / 2) return true;
        }
        if (dx > 0) {
            if (xTemp > 3 - (width + cWidth) / 2) return true;
        }
        return false;
    }


    public abstract void draw();
}
