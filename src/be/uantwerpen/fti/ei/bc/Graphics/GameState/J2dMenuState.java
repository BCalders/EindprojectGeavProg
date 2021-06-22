package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.MenuState;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;

public class J2dMenuState extends MenuState {

    private final J2dGraph gr;

    private Background bg;

    private Color titleColor, selectColor;
    private Font titleFont, font, selectFont;

    private boolean isBlinking;
    private int blinkingCounter;

    public J2dMenuState(J2dGraph gr, GameStateManager gsm) {
        super(gsm);
        this.gr = gr;
    }

    @Override
    public void init() {
        super.init();

        isBlinking = true;
        blinkingCounter = 0;

        try {
            bg = new Background(gr, "/Backgrounds/background.png");
            bg.setVector(0, 0.2);

            titleColor = new Color(0, 255, 180);
            titleFont = new Font("Century Gothic", Font.PLAIN, 60);

            font = new Font("Arial", Font.PLAIN, 30);
            selectFont = new Font("Arial", Font.BOLD, 30);
            selectColor = titleColor.darker().darker();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        super.update();
        bg.update();

        blinkingCounter++;

        if (blinkingCounter > 30) {
            isBlinking = !isBlinking;
            blinkingCounter = 0;
        }
    }

    @Override
    public void draw() {
        Graphics2D g2d = gr.getG2d();
        int titleXLocation, titleYLocation;
        String title = "Space Invaders";

        //draw Background
        bg.draw();

        //draw Title
        g2d.setColor(titleColor);
        g2d.setFont(titleFont);
        titleXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(title)) / 2;
        titleYLocation = J2dGraph.HEIGHT / 4;
        g2d.drawString(title, titleXLocation, titleYLocation);

        //draw menu
        for (int i = 0; i < getOptions().length; i++) {
            int choiceSpacing = 50;
            int choiceYLocation = J2dGraph.HEIGHT / 2 + ((i - 1) * choiceSpacing);
            if (i == getCurrentChoice()) {
                g2d.setFont(selectFont);

                if (isBlinking) g2d.setColor(titleColor);
                else g2d.setColor(selectColor);

                g2d.setStroke(new BasicStroke(2));
                g2d.fillRect(titleXLocation - 10 - 25, choiceYLocation - 23, 25, 25);                    //draw playership icon, nog aan te vullen
            } else {
                g2d.setFont(font);
                g2d.setColor(selectColor);
            }
            g2d.drawString(getOptions()[i], titleXLocation, choiceYLocation);
        }
    }
}
