package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Main.KeyHandler;

public abstract class LevelState extends GameState{

    public LevelState(GameStateManager gsm){
        this.gsm = gsm;
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

    }
}
