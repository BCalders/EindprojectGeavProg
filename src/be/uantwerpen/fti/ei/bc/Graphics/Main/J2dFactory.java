package be.uantwerpen.fti.ei.bc.Graphics.Main;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bonus;
import be.uantwerpen.fti.ei.bc.Game.Entities.Bullet;
import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Game.GameState.*;
import be.uantwerpen.fti.ei.bc.Graphics.Entities.J2dBonus;
import be.uantwerpen.fti.ei.bc.Graphics.GameState.*;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;
import be.uantwerpen.fti.ei.bc.Game.Main.GraphicsClass;
import be.uantwerpen.fti.ei.bc.Graphics.Entities.J2dBullet;
import be.uantwerpen.fti.ei.bc.Graphics.Entities.J2dEnemyShip;
import be.uantwerpen.fti.ei.bc.Graphics.Entities.J2dPlayerShip;

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
    public EnemyShip createEnemyShip(int type) {
        return new J2dEnemyShip(graph, type);
    }

    @Override
    public Bullet createBullet() {
        return new J2dBullet(graph);
    }

    @Override
    public GameState createWinstate(GameStateManager gsm) {
        return new J2dWinState(graph, gsm);
    }

    @Override
    public GameState createGameOverState(GameStateManager gsm) {
        return new J2dGameOverState(graph, gsm);
    }

    @Override
    public PauseState createPauseState(GameStateManager gsm) {
        return new J2dPauseState(graph, gsm);
    }

    @Override
    public Bonus createBonus(int rInt) {
        return new J2dBonus(graph, rInt);
    }

}
