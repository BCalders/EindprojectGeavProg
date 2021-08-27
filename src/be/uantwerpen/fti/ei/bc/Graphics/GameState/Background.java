package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.TextureHandler;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Background {

    private final J2dGraph gr;

    private BufferedImage image;

    private static double x, y;
    private double dx, dy;

    public Background(J2dGraph gr) {
        this.gr = gr;
        image = TextureHandler.backgroundTexture;
    }

    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void update() {
        x = (x + dx) % J2dGraph.WIDTH;
        y = (y + dy) % J2dGraph.HEIGHT;
    }

    public void draw() {
        Graphics2D g2d = gr.getG2d();
        g2d.drawImage(image, (int) x, (int) y, J2dGraph.WIDTH, J2dGraph.HEIGHT, null);

        if (y < 0)
            g2d.drawImage(image, (int) x, (int) y + J2dGraph.HEIGHT, J2dGraph.WIDTH, J2dGraph.HEIGHT, null);
        if (y > 0)
            g2d.drawImage(image, (int) x, (int) y - J2dGraph.HEIGHT, J2dGraph.WIDTH, J2dGraph.HEIGHT, null);

    }
}
