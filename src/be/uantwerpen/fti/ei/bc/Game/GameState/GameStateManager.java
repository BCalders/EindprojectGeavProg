package be.uantwerpen.fti.ei.bc.Game.GameState;


import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;

import java.util.ArrayList;

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

    public void keyPressed(int k) {
        gameStates.get(currentState).keyPressed(k);
    }

    public void keyReleased(int k) {
        gameStates.get(currentState).keyReleased(k);
    }
}
