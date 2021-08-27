package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import be.uantwerpen.fti.ei.bc.Graphics.Audio.AudioPlayer;
import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.TextureHandler;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;
import java.awt.image.BufferedImage;

public class J2dPlayerShip extends PlayerShip {

    private final J2dGraph graph;
    private static BufferedImage[] sprites;
    private final Color doubleColor = new Color(255, 255, 128), shieldColor = new Color(128, 128, 255);

    private static final AudioPlayer playerHit = new AudioPlayer("src/be/uantwerpen/fti/ei/bc/Resources/SFX/Player/PlayerHit.wav", J2dGraph.SFXVOL);

    public J2dPlayerShip(J2dGraph graph) {
        super();
        this.graph = graph;
    }

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

    @Override
    public void draw() {
        Graphics2D g2d = graph.getG2d();

        int xCoord = (int) graph.calculateX(getX());
        int yCoord = (int) graph.calculateY(getY());
        int width2 = (int) graph.reformX(width);
        int height2 = (int) graph.reformY(height);

        int xCCoord = (int) graph.calculateX(getX() + (width - cWidth) / 2);
        int yCCoord = (int) graph.calculateY(getY() - (height - cHeight) / 2);
        int cwidth2 = (int) graph.reformX(cWidth);
        int cheight2 = (int) graph.reformY(cHeight);

        //Test generation

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
