package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;

public class J2dEnemyShip extends EnemyShip {

    private final J2dGraph graph;

    public J2dEnemyShip(J2dGraph graph) {
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
        g2d.setColor(Color.BLUE);
        if(isAlive) g2d.fillRect(xCoord, yCoord, width2, height2);
    }
}
