package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.TextureHandler;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class J2dEnemyShip extends EnemyShip {

    private final J2dGraph graph;

    private static ArrayList<BufferedImage[]> sprites;
    private final Animation animation = new Animation();

    public J2dEnemyShip(J2dGraph graph, int type) {
        super(type);
        this.graph = graph;
        animation.setFrames(sprites.get(this.type));
        animation.setDelay(250);
    }

    public static void loadsprites() {
        sprites = TextureHandler.getEnemyTextures();
    }

    @Override
    public void update() {
        super.update();
        animation.update();
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

//        //Test generation
//        g2d.setColor(Color.BLUE);
//        g2d.fillRect(xCoord, yCoord, width2, height2);
//
//        //draw collision box
//        g2d.setColor(Color.YELLOW);
//        g2d.fillRect(xCCoord, yCCoord, cwidth2, cheight2);


        //draw enemyship

        g2d.drawImage(animation.getFrame(), xCoord, yCoord, width2, height2, null);
    }
}
