package be.uantwerpen.fti.ei.bc.Graphics.Main;

import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.LevelState;
import be.uantwerpen.fti.ei.bc.Game.GameState.MenuState;
import be.uantwerpen.fti.ei.bc.Game.KeyHandler.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;
import be.uantwerpen.fti.ei.bc.Game.Main.GraphicsClass;
import be.uantwerpen.fti.ei.bc.Graphics.Entities.J2dEnemyShip;
import be.uantwerpen.fti.ei.bc.Graphics.Entities.J2dPlayerShip;
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
    public KeyHandler createKeyHandler() {
        return new KeyHandler(graph);
    }

    @Override
    public MenuState createMenuState(GameStateManager gsm){
        return new J2dMenuState(graph, gsm);
    }

    @Override
    public LevelState createLevelState(GameStateManager gsm) {
        return new J2dLevelState(graph, gsm, this);
    }

    @Override
    public PlayerShip createPlayerShip() {
        return new J2dPlayerShip(graph);
    }

    @Override
    public EnemyShip createEnemyShip() {
        return new J2dEnemyShip(graph);
    }
}
