package be.uantwerpen.fti.ei.bc.Game.GameState;

public abstract class GameState {

    protected GameStateManager gsm;

    public abstract void init();
    public abstract void update();
    public abstract void draw();
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);

}
