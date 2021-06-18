package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class Bullet extends Entity{

    public Bullet(){
        this.width = 0.5;
        this.height = 1;
        cHeight = height;
        cWidth = width;
    }

    public void update(){

    }

    public abstract void draw();
}
