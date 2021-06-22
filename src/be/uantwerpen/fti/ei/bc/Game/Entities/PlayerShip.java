package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class PlayerShip extends Entity {

    protected boolean isFlinching = false;
    protected long flinchtimer;

    protected boolean isShooting = false;

    private int fire, fireCost;

    public PlayerShip() {
        this.width = 0.3;
        this.height = 0.2;
        cWidth = 0.2;
        cHeight = 0.2;
        speed = 0.05;
        fire = fireCost = 90;
    }

    public boolean isFlinching(){
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
            if (xTemp > 3 - cWidth) {
                dx = 0;
                x = 3 - cWidth;
            } else
                x = xTemp;
        }

        if(isFlinching && System.currentTimeMillis() - flinchtimer > 400) isFlinching = false;
    }

    public abstract void draw();

    public boolean canFire() {
        return fire == fireCost;
    }

    public void fire() {
        System.out.println("PLAYER SHOOT");
        fire = 0;
    }

    public void hit(){
        if(!isFlinching) {
            isFlinching = true;
            flinchtimer = System.currentTimeMillis();
        }
    }
}