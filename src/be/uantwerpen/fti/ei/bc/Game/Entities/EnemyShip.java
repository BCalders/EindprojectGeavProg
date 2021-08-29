package be.uantwerpen.fti.ei.bc.Game.Entities;

/**
 * Enemies are to be killed to win the game
 *
 * @author Bas Calders
 */
public abstract class EnemyShip extends Entity {
    //enemy state boolean
    protected boolean isDead;

    //enemy type int
    protected int type;

    /**
     * EnemyShip constructor
     *
     * @param type sets type of enemyship
     */
    public EnemyShip(int type) {
        this.width = 0.6;
        this.height = 0.3;
        setType(type);
        cHeight = 0.3;
        if (this.type == 0)
            cWidth = 0.3;
        else
            cWidth = 0.5;
        isDead = false;
        speed = 0.02;
    }

    public boolean shouldRemove() {
        return isDead;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setType(int type) {
        if (type < 2)
            this.type = 2 - type;
        else
            this.type = 0;
    }

    /**
     * Set isDead boolean
     */
    public void kill() {
        isDead = true;
    }

    /**
     * update Enemyship
     */
    public void update() {
        x += dx * speed;
    }

    /**
     * detect collision with right or left edge
     *
     * @return if collision with edge
     */
    public boolean detectEdge() {
        double xTemp = x + dx * speed;
        if (dx < 0) {
            if (xTemp < -3 - (width - cWidth) / 2) return true;
        }
        if (dx > 0) {
            if (xTemp > 3 - (width + cWidth) / 2) return true;
        }
        return false;
    }


    public abstract void draw();
}
