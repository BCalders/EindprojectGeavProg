package be.uantwerpen.fti.ei.bc.Game.Entities;

/**
 * Bullets are shot by enemies or player to deal damage to the other side
 *
 * @author Bas Calders
 */
public abstract class Bullet extends Entity {

    //bullet state booleans
    protected boolean isEnemyBullet, hit, remove;

    /**
     * constructor of Bullet
     */
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

    /**
     * Check if bullet needs to be removed
     *
     * @return if the bullet should be removed
     */
    public boolean shouldRemove() {
        return remove;
    }

    public boolean isEnemyBullet() {
        return isEnemyBullet;
    }

    /**
     * Set if bullet collision with player
     */
    public void setHit() {
        hit = true;
        remove = true;
    }

    /**
     * update the bullet
     */
    public void update() {
        if (isEnemyBullet) y -= dy * speed;
        else y += dy * speed;

        if (hit || Math.abs(y) > 4) {
            remove = true;
        }
    }

    public abstract void draw();
}
