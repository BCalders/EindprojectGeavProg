package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

public abstract class GameOverState extends GameState {

    protected String reason = "";

    public GameOverState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        int[] scores = gsm.getScores();
        int lives = scores[1];
        int time = scores[2];

        if (lives <= 0) reason += "ran out of Lives";
        else if (time <= 0) reason += "ran out of Time";
        else reason = "_ERROR: Unknown reason_";
    }

    @Override
    public void update() {
    }

    @Override
    public abstract void draw();

    @Override
    public void input(KeyHandler key) {
        if (key.enter.isClicked()) gsm.setState(GameStateManager.MENUSTATE);
    }
}