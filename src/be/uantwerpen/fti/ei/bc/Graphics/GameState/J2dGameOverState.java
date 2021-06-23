package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameOverState;
import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;


public class J2dGameOverState extends GameOverState {

    private J2dGraph gr;

    private Color titleColor;
    private Font titleFont, font;

    private boolean linesVisible;
    private int linesVisibleCount;

    public J2dGameOverState(J2dGraph graph, GameStateManager gsm) {
        super(gsm);
        this.gr = graph;
    }

    @Override
    public void init() {
        super.init();

        linesVisible = true;
        linesVisibleCount = 0;

        J2dGraph.bg.setVector(0, 0.2);

        titleColor = new Color(0, 255, 180);
        titleFont = new Font("Century Gothic", Font.BOLD, 60);

        font = new Font("Arial", Font.PLAIN, 30);

    }

    @Override
    public void update() {
        super.update();
        J2dGraph.bg.update();

        linesVisibleCount++;

        if (linesVisibleCount > 30) {
            linesVisible = !linesVisible;
            linesVisibleCount = 0;
        }
    }

    @Override
    public void draw() {
        Graphics2D g2d = gr.getG2d();
        int titleXLocation, titleYLocation;
        String title = "GAME OVER";

        //draw Background
        J2dGraph.bg.draw();

        //draw Title
        g2d.setColor(titleColor);
        g2d.setFont(titleFont);
        titleXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(title)) / 2;
        titleYLocation = J2dGraph.HEIGHT / 4;
        g2d.drawString(title, titleXLocation, titleYLocation);

        g2d.setFont(font);

        //Draw Loss reason
        String reasonString = "Player lost because";
        int reasonXlocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(reasonString)) / 2;
        int reason2Xlocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(reason)) / 2;
        g2d.drawString(reasonString, reasonXlocation, titleYLocation + 60);
        g2d.drawString(reason, reason2Xlocation, titleYLocation + 90);

        //Draw return
        if (linesVisible) {
            String returnString = "-- Press ENTER to continue --";
            int returnXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(returnString)) / 2;
            int returnYLocation = (J2dGraph.HEIGHT / 4) * 3;
            g2d.drawString(returnString, returnXLocation, returnYLocation);
        } else {
            String returnString = "Press ENTER to continue";
            int returnXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(returnString)) / 2;
            int returnYLocation = (J2dGraph.HEIGHT / 4) * 3;
            g2d.drawString(returnString, returnXLocation, returnYLocation);
        }
    }
}
