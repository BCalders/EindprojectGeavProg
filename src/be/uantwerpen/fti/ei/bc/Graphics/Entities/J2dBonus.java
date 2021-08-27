package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bonus;
import be.uantwerpen.fti.ei.bc.Graphics.Audio.AudioPlayer;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.TextureHandler;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;
import java.awt.image.BufferedImage;

public class J2dBonus extends Bonus {

    private final J2dGraph graph;

    private static final AudioPlayer hit = new AudioPlayer("src/be/uantwerpen/fti/ei/bc/Resources/SFX/Bonus/Bonus.wav", J2dGraph.SFXVOL);

    private static BufferedImage[] sprites;

    public J2dBonus(J2dGraph graph, int rInt) {
        super(rInt);
        this.graph = graph;
    }

    public static void loadsprites() {
        sprites = TextureHandler.getBonusTextures();
    }

    @Override
    public void setHit(){
        super.setHit();
        hit.play();
    }

    @Override
    public void draw() {
        Graphics2D g2d = graph.getG2d();

        int xCoord = (int) graph.calculateX(getX());
        int yCoord = (int) graph.calculateY(getY());
        int width2 = (int) graph.reformX(width);
        int height2 = (int) graph.reformY(height);

        //Draw bonus
//        g2d.setColor(new Color(64, 64, 255));
//        g2d.fillRect(xCoord, yCoord, width2, height2);
        g2d.drawImage(sprites[this.getKind()], xCoord, yCoord, width2, height2, null);
    }
}
