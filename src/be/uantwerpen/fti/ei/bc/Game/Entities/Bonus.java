package be.uantwerpen.fti.ei.bc.Game.Entities;

/**
 * Bonuses appear randomly to help player win the game.
 *
 * @author Bas Calders
 */

public abstract class Bonus extends Entity {

    // kinds of bonuses
    public static final int DOUBLE = 0, SHIELD = 1, LIFE = 2, TIME = 3;

    //bonuses active
    private boolean isDouble = false, isShield = false, isLife = false, isTime = false;

    //existence booleans
    protected boolean hit, remove;

    /**
     * Constructor of Bonus
     *
     * @param kind the bonus that is being spawned
     */
    public Bonus(int kind) {
        width = 0.4;
        height = 0.4;
        cHeight = height;
        cWidth = width;
        speed = .05;
        dy = 1;
        setKind(kind);
    }

    private void setKind(int kind) {
        switch (kind) {
            case 0:
                isDouble = true;
                break;
            case 1:
                isShield = true;
                break;
            case 2:
                isLife = true;
                break;
            case 3:
                isTime = true;
                break;
        }
    }


    public int getKind() {
        if (isDouble) return 0;
        if (isShield) return 1;
        if (isLife) return 2;
        if (isTime) return 3;
        return -1;
    }

    /**
     * Check if Bonus needs to be removed
     *
     * @return if the bonus should be removed
     */
    public boolean shouldRemove() {
        return remove;
    }

    /**
     * Set if bonus collision with player
     */
    public void setHit() {
        hit = true;
        remove = true;
    }

    /**
     * update the bonus
     */
    public void update() {
        y -= dy * speed;

        if (hit || Math.abs(y) > 4) {
            remove = true;
        }
    }

    public abstract void draw();
}
