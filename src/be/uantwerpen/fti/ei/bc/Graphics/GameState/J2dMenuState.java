package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.MenuState;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.TextureHandler;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * menustate rendering class
 *
 * @author Bas Calders
 */
public class J2dMenuState extends MenuState {

    //graph
    private final J2dGraph gr;

    //colors and fonts
    private Color titleColor, selectColor;
    private Font titleFont, font, selectFont;

    //graphic vars and booleans
    private boolean isBlinking;
    private int blinkingCounter;

    //sprites
    private BufferedImage icon;

    /**
     * j2dMenustate constructor
     * @param gr graphics class
     * @param gsm gamestatemanager
     */
    public J2dMenuState(J2dGraph gr, GameStateManager gsm) {
        super(gsm);
        this.gr = gr;
    }

    @Override
    public void init() {
        super.init();

        isBlinking = true;
        blinkingCounter = 0;

        titleColor = new Color(0, 255, 180);
        titleFont = new Font("Century Gothic", Font.PLAIN, 60);

        font = new Font("Arial", Font.PLAIN, 30);
        selectFont = new Font("Arial", Font.BOLD, 30);
        selectColor = titleColor.darker().darker();

        icon = TextureHandler.getEnemyTextures().get(0)[0];

        J2dGraph.bg.setVector(0, 0.2);

        J2dGraph.bgMusic.play();
    }

    @Override
    public void update() {
        super.update();
        J2dGraph.bg.update();

        blinkingCounter++;

        if (blinkingCounter > 20) {
            isBlinking = !isBlinking;
            blinkingCounter = 0;
        }
    }


    /**
     * draw menustate to screen
     */
    @Override
    public void draw() {
        Graphics2D g2d = gr.getG2d();
        int titleXLocation, titleYLocation;
        String title = "Space Invaders";

        //draw Background
        J2dGraph.bg.draw();

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
                g2d.drawImage(icon, titleXLocation - 10 - 50, choiceYLocation - 23, 50, 25, null);
            } else {
                g2d.setFont(font);
                g2d.setColor(selectColor);
            }
            g2d.drawString(getOptions()[i], titleXLocation, choiceYLocation);
        }
    }
}
