package be.uantwerpen.fti.ei.bc.Game.Entities;

public abstract class Bonus extends Entity {

    public static final int DOUBLEGUN = 0, SHIELD = 1, LIFE = 2, TIME = 3;
    private boolean isDouble = false, isShield = false, isLife = false, isTime = false;
    protected boolean hit, remove;

    public Bonus(int kind) {
        width = 0.3;
        height = 0.3;
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

    public boolean shouldRemove() {
        return remove;
    }

    public void setHit() {
        hit = true;
        remove = true;
    }


    public void update(){
        y -= dy * speed;

        if (hit || Math.abs(y) > 4) {
            remove = true;
        }
    }

    public abstract void draw();
}
