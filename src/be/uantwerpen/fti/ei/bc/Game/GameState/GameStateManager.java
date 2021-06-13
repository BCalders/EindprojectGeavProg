package be.uantwerpen.fti.ei.bc.Game.GameState;


import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;
import be.uantwerpen.fti.ei.bc.Graphics.Main.KeyHandler;

import java.util.ArrayList;
import java.util.Currency;

public class GameStateManager {

    private AFactory f;

    private ArrayList<GameState> gameStates;
    private int currentState;

    private static final int MENUSTATE = 0, LEVELSTATE = 1;


    public GameStateManager(AFactory f) {
        this.f = f;
        gameStates = new ArrayList<GameState>();

        currentState = MENUSTATE;
        gameStates.add(f.createMenuState(this));
    }

    public void exitGame(String exitReason){
        System.out.println("Game was manually quit: "+ exitReason);
        System.exit(0);
    }

    public void setState(int state) {
        currentState = state;
        gameStates.get(currentState).init();
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
