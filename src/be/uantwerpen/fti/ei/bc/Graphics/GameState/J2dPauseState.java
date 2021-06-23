package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.PauseState;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;

public class J2dPauseState extends PauseState {

    private final J2dGraph gr;

    private Color titleColor;
    private Font titleFont, font;

    private boolean linesVisible;
    private int linesVisibleCount;

    public J2dPauseState(J2dGraph graph, GameStateManager gsm) {
        super(gsm);
        this.gr = graph;
    }

    @Override
    public void init() {
        super.init();

        linesVisible = true;
        linesVisibleCount = 0;

        titleColor = new Color(0, 255, 180);
        titleFont = new Font("Century Gothic", Font.BOLD, 60);

        font = new Font("Arial", Font.PLAIN, 30);
    }

    @Override
    public void update() {
        super.update();

        linesVisibleCount++;

        if (linesVisibleCount > 30) {
            linesVisible = !linesVisible;
            linesVisibleCount = 0;
        }
    }

    @Override
    public void draw() {
        Graphics2D g2d = gr.getG2d();

        //draw last frame of paused State
        pausedState.draw();

        //draw transparent haze
        g2d.setColor(new Color(0,0,0, 0.5f));
        g2d.fillRect(0,0, J2dGraph.WIDTH, J2dGraph.HEIGHT);

        //draw Title
        int titleXLocation, titleYLocation;
        String title = "__Game Paused__";
        g2d.setColor(titleColor);
        g2d.setFont(titleFont);
        titleXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(title)) / 2;
        titleYLocation = J2dGraph.HEIGHT / 3;
        g2d.drawString(title, titleXLocation, titleYLocation);

        //draw return
        g2d.setFont(font);

        if (linesVisible) {
            String returnString = "-- Press 'P' to continue --";
            int returnXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(returnString)) / 2;
            int returnYLocation = J2dGraph.HEIGHT /2;
            g2d.drawString(returnString, returnXLocation, returnYLocation);
        } else {
            String returnString = "Press 'P' to continue";
            int returnXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(returnString)) / 2;
            int returnYLocation = J2dGraph.HEIGHT / 2;
            g2d.drawString(returnString, returnXLocation, returnYLocation);
        }

    }
}
