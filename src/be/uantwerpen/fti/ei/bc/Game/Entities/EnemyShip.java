package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class EnemyShip extends Entity{

    protected boolean isAlive;

    public EnemyShip(){
        this.width = 0.3;
        this.height = 0.3;
        cHeight = 0.2;
        cWidth = 0.2;
        isAlive = true;
    }

    public void kill(){
        isAlive = false;
    }

    public void update(){
        x += dx;
    }

    public abstract void draw();
}
