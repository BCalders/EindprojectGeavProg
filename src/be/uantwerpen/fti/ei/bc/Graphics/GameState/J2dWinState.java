package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.WinState;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;

public class J2dWinState extends WinState {

    protected J2dGraph gr;

    protected Background bg;

    private Color titleColor;
    private Font titleFont, font, selectFont;

    public J2dWinState(J2dGraph graph, GameStateManager gsm) {
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
//            selectFont = new Font("Arial", Font.BOLD, 30);

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
        String title = "You Win";

        //draw Background
        bg.draw();

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
            g2d.setColor(titleColor);


            g2d.drawString(scoreNames[i], titleXLocation, scoreYLocation);
            g2d.drawString(getScoreCalc()[i], scoreXLocation, scoreYLocation);
        }
        //draw return
        String returnString = "-- Press ENTER to continue --";
        int returnXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(returnString)) / 2;
        int returnYLocation = (J2dGraph.HEIGHT / 4) * 3;
        g2d.drawString(returnString, returnXLocation, returnYLocation);
        g2d.drawLine(returnXLocation, returnYLocation + 6, returnXLocation + g2d.getFontMetrics(g2d.getFont()).stringWidth(returnString), returnYLocation + 6);

//        //draw scores
//        for (int i = 0; i < getScoreCalc().length; i++) {
//            int choiceSpacing = 50;
//            int choiceYLocation = J2dGraph.HEIGHT / 2 + ((i - 1) * choiceSpacing);
//            if (i == getCurrentChoice()) {
//                g2d.setFont(selectFont);
//                g2d.setColor(titleColor.darker().darker());
//                g2d.setStroke(new BasicStroke(2));
//                g2d.drawLine(titleXLocation, choiceYLocation + 6, titleXLocation + g2d.getFontMetrics(g2d.getFont()).stringWidth(getOptions()[i]), choiceYLocation + 6);
//            } else {
//                g2d.setFont(font);
//                g2d.setColor(titleColor);
//            }
//            g2d.drawString(getOptions()[i], titleXLocation, choiceYLocation);
//
//        }
    }
}