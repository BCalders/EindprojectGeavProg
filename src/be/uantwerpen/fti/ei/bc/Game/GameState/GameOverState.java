package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.KeyHandler.KeyHandler;

public abstract class GameOverState extends GameState{

    public GameOverState(GameStateManager gsm){
        super(gsm);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public abstract void draw();

    @Override
    public void input(KeyHandler key) {
        if(key.enter.isClicked()) gsm.setState(GameStateManager.MENUSTATE);
    }
}
