package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.HighScoreState;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;

public class J2dHighScoreState extends HighScoreState {

    private final J2dGraph gr;

    private Color titleColor;
    private Font titleFont, font;

    public J2dHighScoreState(J2dGraph gr, GameStateManager gsm) {
        super(gsm);
        this.gr = gr;
    }

    @Override
    public void init() {
        super.init();

        J2dGraph.bg.setVector(0, 0.2);

        titleColor = new Color(0, 255, 180);
        titleFont = new Font("Century Gothic", Font.BOLD, 60);

        font = new Font("Arial", Font.PLAIN, 30);
    }

    @Override
    public void draw() {
        Graphics2D g2d = gr.getG2d();
        int titleXLocation, titleYLocation;
        String title = "HIGHSCORES:";

        //draw Background
        J2dGraph.bg.draw();

        //draw Title
        g2d.setColor(titleColor);
        g2d.setFont(titleFont);
        titleXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(title)) / 2;
        titleYLocation = J2dGraph.HEIGHT / 6;
        g2d.drawString(title, titleXLocation, titleYLocation);
    }
}
