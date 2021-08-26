package be.uantwerpen.fti.ei.bc.Game.GameState;


import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

import java.util.ArrayList;

public class GameStateManager {

    private final ArrayList<GameState> gameStates;
    private final PauseState pauseState;
    private int currentState;

    public static final int MENUSTATE = 0, LEVELSTATE = 1, WINSTATE = 2, GAMEOVERSTATE = 3, HIGHSCORE = 4, PAUSED = 5;
    protected int[] scores;


    public GameStateManager(AFactory f) {
        gameStates = new ArrayList<>();

        currentState = MENUSTATE;
        gameStates.add(f.createMenuState(this));
        gameStates.add(f.createLevelState(this));
        gameStates.add(f.createWinstate(this));
        gameStates.add(f.createGameOverState(this));
        gameStates.add(f.createHighScoreState(this));
        gameStates.add(null);

        pauseState = f.createPauseState(this);
        gameStates.add(pauseState);

        gameStates.get(currentState).init();
    }

    public int[] getScores(){
        return scores;
    }

    public void exitGame(String exitReason){
        System.out.println("Game was manually quit: "+ exitReason);
        System.exit(0);
    }

    public void setState(int state) {
        currentState = state;
        gameStates.get(currentState).init();
    }

    public void continueState(int state){
        currentState = state;
    }

    public void pauseState(GameState state){
        pauseState.init();
        pauseState.pause(state);
        currentState = PAUSED;
        gameStates.get(PAUSED).init();
    }

    public void setScores(int score, int lives, int time){
        scores = new int[]{score, lives, time};
    }

    public void update() {
        gameStates.get(currentState).update();
    }

    public void draw() {
        gameStates.get(currentState).draw();
    }

    public void input(KeyHandler key){
        gameStates.get(currentState).input(key);
        if(key.esc.isDown){
            exitGame("Player pressed ESC!");
        }
    }
}
