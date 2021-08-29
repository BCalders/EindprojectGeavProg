package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import be.uantwerpen.fti.ei.bc.Graphics.Audio.AudioPlayer;
import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.TextureHandler;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Playership rendering class
 *
 * @author Bas Calders
 */
public class J2dPlayerShip extends PlayerShip {

    //rendering
    private final J2dGraph graph;
    private static BufferedImage[] sprites;

    //audioplayer
    private static final AudioPlayer playerHit = new AudioPlayer("src/be/uantwerpen/fti/ei/bc/Resources/SFX/Player/PlayerHit.wav", J2dGraph.SFXVOL);

    /**
     * j2dplayer constructor
     *
     * @param graph graphics class
     */
    public J2dPlayerShip(J2dGraph graph) {
        super();
        this.graph = graph;
    }

    /**
     * load necessary sprites from texturehandler
     */
    public static void loadsprites() {
        sprites = TextureHandler.getPlayershipTextures();
    }

    @Override
    public void hit() {
        super.hit();
        playerHit.play();
    }

    @Override
    public void update() {
        super.update();
    }

    /**
     * draw playership on screen
     */
    @Override
    public void draw() {
        Graphics2D g2d = graph.getG2d();

        //calculate coords
        int xCoord = (int) graph.calculateX(getX());
        int yCoord = (int) graph.calculateY(getY());
        int width2 = (int) graph.reformX(width);
        int height2 = (int) graph.reformY(height);

        if (isFlinching) {
            long elapsed = (System.currentTimeMillis() - flinchtimer);
            if (elapsed / 50 % 2 == 0) return;
        }

        if (isDouble())
            g2d.drawImage(sprites[0], xCoord, yCoord, width2, height2, null);
        else if (isShielded())
            g2d.drawImage(sprites[1], xCoord, yCoord, width2, height2, null);
        else g2d.drawImage(sprites[2], xCoord, yCoord, width2, height2, null);
    }
}
