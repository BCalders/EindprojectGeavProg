package be.uantwerpen.fti.ei.bc.Game.Entities;


public abstract class Bullet extends Entity {

    protected boolean isEnemyBullet, hit, remove;


    public Bullet() {
        width = 0.05;
        height = 0.1;
        cHeight = height;
        cWidth = width;
        speed = .15;
        isEnemyBullet = false;
        dy = 1;
    }

    public void setEnemyBullet() {
        isEnemyBullet = true;
    }

    public boolean shouldRemove() {
        return remove;
    }

    public boolean isEnemyBullet(){
        return isEnemyBullet;
    }

    public void setHit() {
        hit = true;
        remove = true;
    }

    public void update() {
        if (isEnemyBullet) y -= dy * speed;
        else y += dy * speed;

        if (hit || Math.abs(y) > 4) {
            remove = true;
            System.out.println(this + " should be removed");
        }
    }

    public abstract void draw();
}
