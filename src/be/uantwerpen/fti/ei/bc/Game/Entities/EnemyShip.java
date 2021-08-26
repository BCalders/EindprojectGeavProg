package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class EnemyShip extends Entity {

    protected boolean isDead;
    protected int type;

    public EnemyShip(int type) {
        this.width = 0.6;
        this.height = 0.3;
        setType(type);
        cHeight = 0.3;
        if (this.type == 0)
            cWidth = 0.3;
        else
            cWidth = 0.5;
        isDead = false;
        speed = 0.02;
    }

    public boolean shouldRemove() {
        return isDead;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setType(int type) {
        if (type < 2)
            this.type = 2 - type;
        else
            this.type = 0;
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
