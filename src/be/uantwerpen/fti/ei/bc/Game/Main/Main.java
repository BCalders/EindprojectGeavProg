package be.uantwerpen.fti.ei.bc.Game.Main;

import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dFactory;

public class Main {

    public static void main(String[] args) {
        AFactory Factory = new J2dFactory();
        Game g = new Game(Factory);
        g.play();
    }
}
