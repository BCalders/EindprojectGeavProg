package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

public abstract class HighScoreState extends GameState{

    public HighScoreState(GameStateManager gsm){
        super(gsm);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    public abstract void draw();

    @Override
    public void input(KeyHandler key) {
            if (key.enter.isClicked()) gsm.setState(GameStateManager.MENUSTATE);
    }
}
