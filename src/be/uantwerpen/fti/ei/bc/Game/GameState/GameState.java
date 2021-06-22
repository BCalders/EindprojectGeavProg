package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.KeyHandler.KeyHandler;

public abstract class GameState {

    protected GameStateManager gsm;

    public GameState(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void init();
    public abstract void update();
    public abstract void draw();
    public abstract void input(KeyHandler key);

}
