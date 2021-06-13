package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import be.uantwerpen.fti.ei.bc.Game.Entities.TestSquare;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;

public class J2dTestSquare extends TestSquare {

    private J2dGraph gr;

    public J2dTestSquare(J2dGraph gr, int x, int y, double dx, double dy) {
        super(x, y, dx, dy);
        this.gr = gr;
    }

    @Override
    public void draw() {
        Graphics2D g2d = gr.getG2d();
        g2d.setColor(Color.GREEN);
        g2d.fillRect(getX(), getY() , 10, 10);
    }
}
