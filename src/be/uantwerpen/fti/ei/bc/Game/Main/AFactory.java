package be.uantwerpen.fti.ei.bc.Game.Main;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bullet;
import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.LevelState;
import be.uantwerpen.fti.ei.bc.Game.GameState.MenuState;
import be.uantwerpen.fti.ei.bc.Game.KeyHandler.KeyHandler;

public abstract class AFactory {

    public AFactory() {
    }

    public abstract GraphicsClass createGraphicsClass();

    public abstract MenuState createMenuState(GameStateManager gsm);

    public abstract KeyHandler createKeyHandler();

    public abstract LevelState createLevelState(GameStateManager gsm);

    public abstract PlayerShip createPlayerShip();

    public abstract EnemyShip createEnemyShip();

    public abstract Bullet createBullet();
}
