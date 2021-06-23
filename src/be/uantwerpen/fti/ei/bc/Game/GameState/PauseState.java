package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

public abstract class PauseState extends GameState{

    protected GameState pausedState;

    public PauseState(GameStateManager gsm){
        super(gsm);
    }

    public void pause(GameState pausedState){
        this.pausedState = pausedState;

    }

    @Override
    public void init() {
        //nothing to init
    }

    @Override
    public void update() {
        //No updates to keep game saved
    }

    @Override
    public abstract void draw();

    @Override
    public void input(KeyHandler key) {
        if(key.pause.isClicked()){
            gsm.continueState(GameStateManager.LEVELSTATE);
        }
    }
}
