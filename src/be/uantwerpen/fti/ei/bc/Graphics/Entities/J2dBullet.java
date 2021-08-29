package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import be.uantwerpen.fti.ei.bc.Graphics.Audio.AudioPlayer;
import be.uantwerpen.fti.ei.bc.Game.Entities.Bullet;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;

/**
 * bullet rendering class
 *
 * @author Bas Calders
 */
public class J2dBullet extends Bullet {

    //graph
    private final J2dGraph graph;

    //audioplayer
    private static final AudioPlayer shoot = new AudioPlayer("src/be/uantwerpen/fti/ei/bc/Resources/SFX/Bullets/shoot.wav", J2dGraph.SFXVOL);

    /**
     * j2dbullet constructor
     *
     * @param graph graphics class
     */
    public J2dBullet(J2dGraph graph) {
        super();
        this.graph = graph;
        shoot.play();
    }

    /**
     * draw bullet on screen
     */
    @Override
    public void draw() {
        Graphics2D g2d = graph.getG2d();

        //calculate coords
        int xCoord = (int) graph.calculateX(getX());
        int yCoord = (int) graph.calculateY(getY());
        int width2 = (int) graph.reformX(width);
        int height2 = (int) graph.reformY(height);

        //Draw bullet
        if (hit) g2d.setColor(Color.RED);
        else if (isEnemyBullet) g2d.setColor(new Color(255, 64, 64));
        else g2d.setColor(new Color(64, 255, 64));
        g2d.fillRect(xCoord, yCoord, width2, height2);
    }
}
