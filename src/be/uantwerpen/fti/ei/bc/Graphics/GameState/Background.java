package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.Main.Game;
import be.uantwerpen.fti.ei.bc.Game.Main.GraphicsClass;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {

    private J2dGraph gr;

    private BufferedImage image;

    private double x, y, dx, dy;

    public Background(J2dGraph gr, String s){

        try {
            image = ImageIO.read(getClass().getResourceAsStream(s));
            this.gr = gr;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPos(double x, double y){
        this.x = x % J2dGraph.WIDTH;
        this.y = y % J2dGraph.HEIGHT;
    }

    public void setVector(double dx, double dy){
        this.dx = dx;
        this.dy = dy;
    }

    public void update(){
        x = (x + dx) % J2dGraph.WIDTH;
        y = (y + dy) % J2dGraph.HEIGHT;
    }

    public void draw(){
        Graphics2D g2d = gr.getG2d();
        g2d.drawImage(image, (int)x, (int)y, null);

        if(y<0)
            g2d.drawImage(image, (int)x, (int)y + J2dGraph.HEIGHT ,null);
        if(y>0)
            g2d.drawImage(image, (int)x, (int)y - J2dGraph.HEIGHT,null);

    }
}
