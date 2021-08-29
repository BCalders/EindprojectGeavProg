package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bonus;
import be.uantwerpen.fti.ei.bc.Graphics.Audio.AudioPlayer;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.TextureHandler;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Main game class, all gameplay is handled in this class
 *
 * @author Bas Calders
 */
public class J2dBonus extends Bonus {

    //graphics vars
    private final J2dGraph graph;

    //audioplayer
    private static final AudioPlayer hit = new AudioPlayer("src/be/uantwerpen/fti/ei/bc/Resources/SFX/Bonus/Bonus.wav", J2dGraph.SFXVOL);

    //sprites
    private static BufferedImage[] sprites;

    /**
     * j2dbonus constructor
     *
     * @param graph graphics class
     * @param rInt  random integer
     */
    public J2dBonus(J2dGraph graph, int rInt) {
        super(rInt);
        this.graph = graph;
    }

    /**
     * load sprites from texturehandler
     */
    public static void loadsprites() {
        sprites = TextureHandler.getBonusTextures();
    }

    @Override
    public void setHit() {
        super.setHit();
        hit.play();
    }

    /**
     * draw bonus on screen
     */
    @Override
    public void draw() {
        Graphics2D g2d = graph.getG2d();

        //calculate coords
        int xCoord = (int) graph.calculateX(getX());
        int yCoord = (int) graph.calculateY(getY());
        int width2 = (int) graph.reformX(width);
        int height2 = (int) graph.reformY(height);

        //Draw bonus
        g2d.drawImage(sprites[this.getKind()], xCoord, yCoord, width2, height2, null);
    }
}
