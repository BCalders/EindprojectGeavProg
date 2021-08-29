package be.uantwerpen.fti.ei.bc.Game.Main;

import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dFactory;

/**
 * the games main class, generates and calls necessary objects to run game
 *
 * @author Bas Calders
 */
public class Main {

    public static void main(String[] args) {
        AFactory Factory = new J2dFactory();
        Game g = new Game(Factory);
        g.play();
    }
}
