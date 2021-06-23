package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.WinState;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;

public class J2dWinState extends WinState {

    private final J2dGraph gr;


    private Color titleColor;
    private Font titleFont, font;

    private boolean linesVisible;
    private int linesVisibleCount;

    public J2dWinState(J2dGraph graph, GameStateManager gsm) {
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
        String title = "YOU WIN!";

        //draw Background
        J2dGraph.bg.draw();

        //draw Title
        g2d.setColor(titleColor);
        g2d.setFont(titleFont);
        titleXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(title)) / 2;
        titleYLocation = J2dGraph.HEIGHT / 4;
        g2d.drawString(title, titleXLocation, titleYLocation);

        //draw scores
        int scoreSpacing = 50;
        int scoreYLocation;
        int scoreXLocation = J2dGraph.WIDTH / 2;

        for (int i = 0; i < scoreNames.length; i++) {
            scoreYLocation = J2dGraph.HEIGHT / 2 + ((i - 1) * scoreSpacing);
            g2d.setFont(font);

            g2d.drawString(scoreNames[i], titleXLocation, scoreYLocation);
            g2d.drawString(getScoreCalc()[i], scoreXLocation, scoreYLocation);
        }
        g2d.drawLine(
                titleXLocation,
                J2dGraph.HEIGHT / 2 + (scoreSpacing) + 10,
                scoreXLocation + g2d.getFontMetrics(g2d.getFont()).stringWidth(getScoreCalc()[1]),
                J2dGraph.HEIGHT / 2 + (scoreSpacing) + 10
        );

        //draw return
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