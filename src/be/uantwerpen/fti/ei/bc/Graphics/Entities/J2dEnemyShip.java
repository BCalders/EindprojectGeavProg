package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import be.uantwerpen.fti.ei.bc.Graphics.Audio.AudioPlayer;
import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.TextureHandler;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * enemyship rendering class
 *
 * @author Bas Calders
 */
public class J2dEnemyShip extends EnemyShip {

    //graph
    private final J2dGraph graph;

    //sprites
    private static ArrayList<BufferedImage[]> sprites;
    private final Animation animation = new Animation();

    //audioplayer
    private static final AudioPlayer eHit = new AudioPlayer("src/be/uantwerpen/fti/ei/bc/Resources/SFX/Enemies/EnemyHit2.wav", J2dGraph.SFXVOL);

    /**
     * j2dEnemyship constructor
     *
     * @param graph graphics class
     * @param type  enemy type
     */
    public J2dEnemyShip(J2dGraph graph, int type) {
        super(type);
        this.graph = graph;
        animation.setFrames(sprites.get(this.type));
        animation.setDelay(250);
    }

    /**
     * load sprites from texturehandler
     */
    public static void loadsprites() {
        sprites = TextureHandler.getEnemyTextures();
    }

    @Override
    public void kill() {
        super.kill();
        eHit.play();
    }

    @Override
    public void update() {
        super.update();
        animation.update();
    }

    /**
     * draw enemies to screen
     */
    @Override
    public void draw() {
        Graphics2D g2d = graph.getG2d();

        int xCoord = (int) graph.calculateX(getX());
        int yCoord = (int) graph.calculateY(getY());
        int width2 = (int) graph.reformX(width);
        int height2 = (int) graph.reformY(height);

        //draw enemyship
        g2d.drawImage(animation.getFrame(), xCoord, yCoord, width2, height2, null);
    }
}
