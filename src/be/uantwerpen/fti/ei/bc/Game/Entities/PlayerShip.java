package be.uantwerpen.fti.ei.bc.Game.Entities;

/**
 * Playership is the main player
 *
 * @author Bas Calders
 */

public abstract class PlayerShip extends Entity {

    //flinching vars
    protected boolean isFlinching = false;
    protected long flinchtimer;

    //shooting vars
    protected boolean isShooting = false;
    private int fire;
    private final int fireCost;

    //bonus booleans
    private boolean isShielded = false;
    private boolean isDouble = false;
    private long bonustimer;

    /**
     * constructor fo playership
     */
    public PlayerShip() {
        this.width = 0.4;
        this.height = 0.2;
        cWidth = 0.35;
        cHeight = 0.2;
        speed = 0.03;
        fire = fireCost = 45;
    }

    public boolean isFlinching() {
        return isFlinching;
    }

    /**
     * update playership
     */
    public void update() {
        //fire
        if (fire != fireCost) {
            fire++;
            isShooting = true;
        } else {
            fire = fireCost;
            isShooting = false;
        }

        //movement
        double xTemp = x + dx * speed;
        if (dx < 0) {
            if (xTemp < -3 - (width - cWidth) / 2) {
                dx = 0;
                x = -3 - (width - cWidth) / 2;
            } else
                x = xTemp;
        }
        if (dx > 0) {
            if (xTemp > 3 - (width + cWidth) / 2) {
                dx = 0;
                x = 3 - cWidth;
            } else
                x = xTemp;
        }

        //check done flinching
        if (isFlinching && (System.currentTimeMillis() - flinchtimer) > 1000) isFlinching = false;

        //bonustime
        if ((isDouble || isShielded) && (System.currentTimeMillis() - bonustimer) > 5000) stopBonus();
    }

    public abstract void draw();

    /**
     * return if player can fire again
     *
     * @return if player can fire again
     */
    public boolean canFire() {
        return fire == fireCost;
    }

    /**
     * set firecounter back to 0
     */
    public void fire() {
        fire = 0;
    }

    /**
     * set hit with bullet
     */
    public void hit() {
        if (isFlinching) return;
        isFlinching = true;
        flinchtimer = System.currentTimeMillis();
    }

    /**
     * start new bonus
     *
     * @param kind of bonus
     */
    public void bonus(int kind) {
        stopBonus();
        System.out.println("bonus: " + kind);
        if (kind == Bonus.DOUBLE) isDouble = true;
        if (kind == Bonus.SHIELD) isShielded = true;
        bonustimer = System.currentTimeMillis();
    }

    /**
     * stop bonus effects
     */
    public void stopBonus() {
        isShielded = false;
        isDouble = false;
    }

    public boolean isShielded() {
        return isShielded;
    }

    public boolean isDouble() {
        return isDouble;
    }
}