package be.uantwerpen.fti.ei.bc.Game.Main;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bullet;
import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Game.GameState.*;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

public abstract class AFactory {

    public AFactory() {
    }

    public abstract GraphicsClass createGraphicsClass();

    public abstract MenuState createMenuState(GameStateManager gsm);

    public abstract KeyHandler createKeyHandler();

    public abstract LevelState createLevelState(GameStateManager gsm);

    public abstract PlayerShip createPlayerShip();

    public abstract EnemyShip createEnemyShip(int type);

    public abstract Bullet createBullet();

    public abstract GameState createWinstate(GameStateManager gsm);

    public abstract GameState createGameOverState(GameStateManager gsm);

    public abstract PauseState createPauseState(GameStateManager gsm);
}
