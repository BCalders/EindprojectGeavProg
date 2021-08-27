package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class PlayerShip extends Entity {

    protected boolean isFlinching = false;
    protected long flinchtimer;

    protected boolean isShooting = false;

    private boolean isShielded = false;
    private boolean isDouble = false;
    private long bonustimer;

    private int fire;
    private final int fireCost;

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

    public boolean canFire() {
        return fire == fireCost;
    }

    public void fire() {
        fire = 0;
    }

    public void hit() {
        if (isFlinching) return;
        isFlinching = true;
        flinchtimer = System.currentTimeMillis();
    }

    public void bonus(int kind) {
        stopBonus();
        System.out.println("bonus: " + kind);
        if (kind == 0) isDouble = true;
        if (kind == 1) isShielded = true;
        bonustimer = System.currentTimeMillis();
    }

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