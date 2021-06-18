package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class EnemyShip extends Entity{

    private boolean isAlive;

    public EnemyShip(){
        this.width = 2;
        this.height = 2;
        cHeight = height;
        cWidth = width;
    }

    public void update(){

    }

    public abstract void draw();
}
