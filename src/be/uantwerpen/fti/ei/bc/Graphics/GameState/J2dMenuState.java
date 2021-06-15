package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.MenuState;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;
import java.awt.geom.Line2D;

public class J2dMenuState extends MenuState {

    private final J2dGraph gr;

    private Background bg;

    private Color titleColor, selectColor;
    private Font titleFont, font;

    public J2dMenuState(J2dGraph gr, GameStateManager gsm) {
        super(gsm);
        this.gr = gr;

        try {
            bg = new Background(gr, "/Backgrounds/background.png");
            bg.setVector(0, 0.1);

            titleColor = new Color(160, 255, 0);
            titleFont = new Font("Century Gothic", Font.PLAIN, 60);

            selectColor = new Color(235, 255, 200);
            font = new Font("Arial", Font.PLAIN, 30);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        super.update();
        bg.update();
    }

    @Override
    public void draw() {
        Graphics2D g2d = gr.getG2d();
        int titleLocation;
        String title = "Space Invaders";

        //draw Background
        bg.draw();

        //draw Title
        g2d.setColor(titleColor);
        g2d.setFont(titleFont);
        titleLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(title))/2;
        g2d.drawString(title, titleLocation, 200);

        //draw menu
        g2d.setFont(font);
        for (int i = 0; i < getOptions().length; i++) {
            if (i == getCurrentChoice()) {
                g2d.setColor(selectColor);
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(titleLocation, 350 + (i * 40) + 6, titleLocation + g2d.getFontMetrics(g2d.getFont()).stringWidth(getOptions()[i]), 350 + (i * 40) + 6);
            } else {
                g2d.setColor(titleColor);
            }
            g2d.drawString(getOptions()[i], titleLocation, 350 + i * 40);
        }
    }
}
