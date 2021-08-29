package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

/**
 * state when paused
 *
 * @author Bas Calders
 */
public abstract class PauseState extends GameState {
    //paused gamestate
    protected GameState pausedState;

    /**
     * pausestate constructor
     *
     * @param gsm instance of gamestatemanager
     */
    public PauseState(GameStateManager gsm) {
        super(gsm);
    }

    /**
     * pause a state
     *
     * @param pausedState state to be paused
     */
    public void pause(GameState pausedState) {
        this.pausedState = pausedState;
    }

    @Override
    public void init() {
        //nothing to init
    }

    @Override
    public void update() {
        //No updates
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
        if (key.pause.isClicked()) {
            gsm.continueState(GameStateManager.LEVELSTATE);
        }
    }
}
