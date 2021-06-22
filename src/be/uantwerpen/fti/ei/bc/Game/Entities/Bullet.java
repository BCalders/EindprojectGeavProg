package be.uantwerpen.fti.ei.bc.Game.Entities;

import java.awt.image.BufferedImage;

public abstract class Bullet extends Entity{

    private boolean isEnemyBullet, hit, remove;
    private BufferedImage sprite, hitSprite;

    public Bullet(){
        width = 0.5;
        height = 1;
        cHeight = height;
        cWidth = width;
    }

    public void update(){

    }

    public abstract void draw();
}
