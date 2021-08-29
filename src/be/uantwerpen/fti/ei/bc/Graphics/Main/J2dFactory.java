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

/**
 * factory for all j2d classes
 *
 * @author Bas Calders
 */
public class J2dFactory extends AFactory {

    //graph
    private J2dGraph graph;

    /**
     * j2dfactory constructor
     */
    public J2dFactory() {
    }

    /**
     * create new graphicsclass
     *
     * @return
     */
    public GraphicsClass createGraphicsClass() {
        graph = new J2dGraph();
        return graph;
    }

    /**
     * create new keyhandler
     *
     * @return keyhandler
     */
    @Override
    public KeyHandler createKeyHandler() {
        return new KeyHandler(graph);
    }

    /**
     * create new menustate
     *
     * @param gsm gamestatemanager
     * @return j2dmenustate
     */
    @Override
    public MenuState createMenuState(GameStateManager gsm) {
        return new J2dMenuState(graph, gsm);
    }

    /**
     * create new levelstate
     *
     * @param gsm gamestatemanager
     * @return j2dlevelstate
     */
    @Override
    public LevelState createLevelState(GameStateManager gsm) {
        return new J2dLevelState(graph, gsm, this);
    }

    /**
     * create new playership
     *
     * @return j2dplayership
     */
    @Override
    public PlayerShip createPlayerShip() {
        return new J2dPlayerShip(graph);
    }

    /**
     * create new enemyship
     *
     * @param type enemyship type
     * @return j2denemyship
     */
    @Override
    public EnemyShip createEnemyShip(int type) {
        return new J2dEnemyShip(graph, type);
    }

    /**
     * create new bullet
     *
     * @return j2dbullet
     */
    @Override
    public Bullet createBullet() {
        return new J2dBullet(graph);
    }

    /**
     * create new winstate
     *
     * @param gsm gamestatemanager
     * @return j2dwinstate
     */
    @Override
    public GameState createWinstate(GameStateManager gsm) {
        return new J2dWinState(graph, gsm);
    }

    /**
     * create new gameovestate
     *
     * @param gsm gamestatemanager
     * @return j2dgameoverstate
     */
    @Override
    public GameState createGameOverState(GameStateManager gsm) {
        return new J2dGameOverState(graph, gsm);
    }

    /**
     * create new pausestate
     *
     * @param gsm gamestatemanager
     * @return j2dpausestate
     */
    @Override
    public PauseState createPauseState(GameStateManager gsm) {
        return new J2dPauseState(graph, gsm);
    }

    /**
     * create new bonus
     *
     * @param rInt random int
     * @return j2dbonus
     */
    @Override
    public Bonus createBonus(int rInt) {
        return new J2dBonus(graph, rInt);
    }

}
