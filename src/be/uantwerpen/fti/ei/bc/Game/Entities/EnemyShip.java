package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class EnemyShip extends Entity{

    protected boolean isDead;

    public EnemyShip(){
        this.width = 0.3;
        this.height = 0.3;
        cHeight = 0.2;
        cWidth = 0.2;
        isDead = false;
        speed = 0.02;
    }

    public boolean shouldRemove() {
        return isDead;
    }

    public void kill(){
        isDead = true;
    }

    public void update(){
        x += dx * speed;
    }

    public abstract void draw();
}
