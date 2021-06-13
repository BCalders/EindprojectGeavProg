package be.uantwerpen.fti.ei.bc.Game.Main;

import be.uantwerpen.fti.ei.bc.Game.Entities.TestSquare;
import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.MenuState;

public abstract class AFactory {

    public AFactory() {
    }

    public abstract GraphicsClass createGraphicsClass();

    public abstract MenuState createMenuState(GameStateManager gsm);

    public abstract TestSquare createTS(int x, int y, double dx, double dy);
}
