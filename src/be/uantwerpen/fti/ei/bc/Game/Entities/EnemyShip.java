package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class EnemyShip extends Entity{

    protected boolean isAlive;

    public EnemyShip(){
        this.width = 0.3;
        this.height = 0.3;
        cHeight = 0.2;
        cWidth = 0.2;
        isAlive = true;
        speed = 0.02;
    }

    public void kill(){
        isAlive = false;
    }

    public void update(){
        x += dx * speed;
    }

    public abstract void draw();
}
