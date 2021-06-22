package be.uantwerpen.fti.ei.bc.Game.GameState;


import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;
import be.uantwerpen.fti.ei.bc.Graphics.KeyHandler.KeyHandler;

import java.util.ArrayList;

public class GameStateManager {

    private final ArrayList<GameState> gameStates;
    private int currentState;

    public static final int MENUSTATE = 0, LEVELSTATE = 1, WINSTATE = 2, GAMEOVERSTATE = 3, PAUSESTATE = 4, HIGHSCORE = 5;
    protected int[] scores;


    public GameStateManager(AFactory f) {
        gameStates = new ArrayList<>();

        currentState = MENUSTATE;
        gameStates.add(f.createMenuState(this));
        gameStates.add(f.createLevelState(this));
        gameStates.add(f.createWinstate(this));

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
        if(key.pause.isClicked()){
            pauseInput();
        }
    }

    private void pauseInput() {
        System.out.println("PAUSE KEY WAS PRESSED");
    }
}
