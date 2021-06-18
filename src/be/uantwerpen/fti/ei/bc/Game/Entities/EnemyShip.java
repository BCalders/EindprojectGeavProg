package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class EnemyShip extends Entity{

    protected boolean isAlive;

    public EnemyShip(){
        this.width = 2;
        this.height = 2;
        cHeight = height;
        cWidth = width;
        isAlive = true;
    }

    public void kill(){
        isAlive = false;
    }

    public void update(){

    }

    public abstract void draw();
}
