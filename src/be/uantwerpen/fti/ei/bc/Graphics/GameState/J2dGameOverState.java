package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameOverState;
import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;


public class J2dGameOverState extends GameOverState {

    private J2dGraph gr;

    protected Background bg;

    private Color titleColor;
    private Font titleFont, font;

    public J2dGameOverState(J2dGraph graph, GameStateManager gsm){
        super(gsm);
        this.gr = graph;
    }

    @Override
    public void init() {
        super.init();

        try {
            bg = new Background(gr, "/Backgrounds/background.png");
            bg.setVector(0, 0.2);

            titleColor = new Color(0, 255, 180);
            titleFont = new Font("Century Gothic", Font.BOLD, 60);

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
        int titleXLocation, titleYLocation;
        String title = "GAME OVER";

        //draw Background
        bg.draw();

        //draw Title
        g2d.setColor(titleColor);
        g2d.setFont(titleFont);
        titleXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(title)) / 2;
        titleYLocation = J2dGraph.HEIGHT / 4;
        g2d.drawString(title, titleXLocation, titleYLocation);

        g2d.setFont(font);

        String returnString = "-- Press ENTER to continue --";
        int returnXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(returnString)) / 2;
        int returnYLocation = (J2dGraph.HEIGHT / 4) * 3;
        g2d.drawString(returnString, returnXLocation, returnYLocation);
        g2d.drawLine(returnXLocation, returnYLocation + 6, returnXLocation + g2d.getFontMetrics(g2d.getFont()).stringWidth(returnString), returnYLocation + 6);
    }
}
