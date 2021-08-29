package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

import java.util.ArrayList;

/**
 * GameStateManager manages the gamestates when switching
 *
 * @author Bas Calders
 */
public class GameStateManager {

    //gamestate vars
    private final ArrayList<GameState> gameStates;
    private final PauseState pauseState;
    private int currentState;

    //gamestate types
    public static final int MENUSTATE = 0, LEVELSTATE = 1, WINSTATE = 2, GAMEOVERSTATE = 3, PAUSED = 4;

    //scores at end of game
    protected int[] scores;

    /**
     * constructor of Gamestate manager
     *
     * @param f needs Abstract Factory or subclass to generate states
     */
    public GameStateManager(AFactory f) {
        gameStates = new ArrayList<>();

        currentState = MENUSTATE;
        gameStates.add(f.createMenuState(this));
        gameStates.add(f.createLevelState(this));
        gameStates.add(f.createWinstate(this));
        gameStates.add(f.createGameOverState(this));
        pauseState = f.createPauseState(this);
        gameStates.add(pauseState);

        gameStates.get(currentState).init();
    }

    public int[] getScores() {
        return scores;
    }

    /**
     * Stop playing in safe manner
     *
     * @param exitReason String to say the reason of exit
     */
    public void exitGame(String exitReason) {
        System.out.println("Game was manually quit: " + exitReason);
        System.exit(0);
    }

    public void setState(int state) {
        currentState = state;
        gameStates.get(currentState).init();
    }

    /**
     * continue the state after pausing
     *
     * @param state that will be continued
     */
    public void continueState(int state) {
        currentState = state;
    }

    /**
     * pause a state
     *
     * @param state that will be paused
     */
    public void pauseState(GameState state) {
        pauseState.init();
        pauseState.pause(state);
        currentState = PAUSED;
        gameStates.get(PAUSED).init();
    }

    public void setScores(int score, int lives, int time) {
        scores = new int[]{score, lives, time};
    }

    /**
     * update current state
     */
    public void update() {
        gameStates.get(currentState).update();
    }

    /**
     * draw current gamestate
     */
    public void draw() {
        gameStates.get(currentState).draw();
    }

    /**
     * get inputs
     *
     * @param key inputted key
     */
    public void input(KeyHandler key) {
        gameStates.get(currentState).input(key);
        if (key.esc.isDown) {
            exitGame("Player pressed ESC!");
        }
    }
}
