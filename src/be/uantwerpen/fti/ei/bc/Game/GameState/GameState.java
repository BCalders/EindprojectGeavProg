package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;
/**
 * abstract class for all gamestates
 *
 * @author Bas Calders
 */
public abstract class GameState {

    //gamestatemanager
    protected GameStateManager gsm;

    /**
     * construcotr gamestate
     * @param gsm instance of gamestatemanager
     */
    public GameState(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void init();
    public abstract void update();
    public abstract void draw();
    public abstract void input(KeyHandler key);

}
