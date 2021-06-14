package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.LevelState;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

public class J2dLevelState extends LevelState {

    private J2dGraph gr;

    public J2dLevelState(J2dGraph graph, GameStateManager gsm) {
        super(gsm);
        this.gr = graph;
    }

    @Override
    public void draw() {

    }
}
