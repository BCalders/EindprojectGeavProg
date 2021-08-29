package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

/**
 * state if gameover
 *
 * @author Bas Calders
 */
public abstract class GameOverState extends GameState {

    protected String reason = null;

    /**
     * gameover constructor
     * @param gsm instance of gamestatemanger
     */
    public GameOverState(GameStateManager gsm) {
        super(gsm);
    }

    /**
     * init gameoverstate
     */
    @Override
    public void init() {
        int[] scores = gsm.getScores();
        int lives = scores[1];
        int time = scores[2];

        if (lives <= 0) reason = "they were Destroyed";
        else if (time <= 0) reason = "they ran out of Time";
        else reason = "Aliens reached destination";
    }

    @Override
    public void update() {
    }

    @Override
    public abstract void draw();

    /**
     * get inputs
     *
     * @param key inputted key
     */
    @Override
    public void input(KeyHandler key) {
        if (key.enter.isClicked()) gsm.setState(GameStateManager.MENUSTATE);
    }
}
