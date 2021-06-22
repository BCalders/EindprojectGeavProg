package be.uantwerpen.fti.ei.bc.Game.Entities;

import java.awt.image.BufferedImage;

public abstract class Bullet extends Entity{

    private boolean isEnemyBullet, hit, remove;
    private BufferedImage sprite, hitSprite;

    public Bullet(){
        width = 0.05;
        height = 0.1;
        cHeight = height;
        cWidth = width;
        speed = 1;
    }

    public void update(){

    }

    public abstract void draw();
}
