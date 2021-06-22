package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bullet;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;
import java.awt.image.BufferedImage;

public class J2dBullet extends Bullet {

    private final J2dGraph graph;

    private BufferedImage hitSprite;

    public J2dBullet(J2dGraph graph){
        super();
        this.graph = graph;
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

        //Test generation
        if(hit) g2d.setColor(Color.RED);
        else if(isEnemyBullet) g2d.setColor(new Color(255, 127,127));
        else g2d.setColor(new Color(127, 127, 255));
        g2d.fillRect(xCoord, yCoord, width2, height2);
    }
}
