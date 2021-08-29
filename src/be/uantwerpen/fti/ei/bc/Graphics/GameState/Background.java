package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.TextureHandler;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * Background class, purely graphical
 *
 * @author Bas Calders
 */
public class Background {

    //graph
    private final J2dGraph gr;

    //background image
    private final BufferedImage image;

    //background pos en vect
    private static double x, y;
    private double dx, dy;

    /**
     * background constructor
     *
     * @param gr graphics class
     */
    public Background(J2dGraph gr) {
        this.gr = gr;
        image = TextureHandler.backgroundTexture;
    }

    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * update background
     */
    public void update() {
        x = (x + dx) % J2dGraph.WIDTH;
        y = (y + dy) % J2dGraph.HEIGHT;
    }

    /**
     * draw background to screen
     */
    public void draw() {
        Graphics2D g2d = gr.getG2d();
        g2d.drawImage(image, (int) x, (int) y, J2dGraph.WIDTH, J2dGraph.HEIGHT, null);

        if (y < 0)
            g2d.drawImage(image, (int) x, (int) y + J2dGraph.HEIGHT, J2dGraph.WIDTH, J2dGraph.HEIGHT, null);
        if (y > 0)
            g2d.drawImage(image, (int) x, (int) y - J2dGraph.HEIGHT, J2dGraph.WIDTH, J2dGraph.HEIGHT, null);

    }
}
