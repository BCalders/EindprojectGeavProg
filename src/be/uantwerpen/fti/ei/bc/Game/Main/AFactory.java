package be.uantwerpen.fti.ei.bc.Game.Main;

import be.uantwerpen.fti.ei.bc.Game.Entities.TestSquare;

public abstract class AFactory {

    public AFactory() {
    }

    public abstract GraphicsClass createGraphicsClass();

    public abstract TestSquare createTS(int x, int y, double dx, double dy);
}
