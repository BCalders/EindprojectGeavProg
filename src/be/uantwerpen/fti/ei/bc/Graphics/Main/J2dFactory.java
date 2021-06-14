package be.uantwerpen.fti.ei.bc.Graphics.Main;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.LevelState;
import be.uantwerpen.fti.ei.bc.Game.GameState.MenuState;
import be.uantwerpen.fti.ei.bc.Game.KeyHandler.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;
import be.uantwerpen.fti.ei.bc.Game.Main.GraphicsClass;
import be.uantwerpen.fti.ei.bc.Game.Entities.TestSquare;
import be.uantwerpen.fti.ei.bc.Graphics.Entities.J2dTestSquare;
import be.uantwerpen.fti.ei.bc.Graphics.GameState.J2dLevelState;
import be.uantwerpen.fti.ei.bc.Graphics.GameState.J2dMenuState;

public class J2dFactory extends AFactory {

    private J2dGraph graph;

    public J2dFactory() {
    }

    public GraphicsClass createGraphicsClass(){
        graph =  new J2dGraph();
        return graph;
    }

    @Override
    public TestSquare createTS(int x, int y, double dx, double dy) {
        return new J2dTestSquare(graph, x, y, dx, dy);
    }

    @Override
    public KeyHandler createKeyHandler() {
        return new KeyHandler(graph);
    }

    @Override
    public MenuState createMenuState(GameStateManager gsm){
        return new J2dMenuState(graph, gsm);
    }

    @Override
    public LevelState createLevelState(GameStateManager gsm) {
        return new J2dLevelState(graph, gsm);
    }


}
