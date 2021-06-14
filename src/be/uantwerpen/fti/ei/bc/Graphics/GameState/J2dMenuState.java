package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.MenuState;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;

public class J2dMenuState extends MenuState {

    private final J2dGraph gr;

    private Background bg;

    private Color titleColor;
    private Font titleFont;
    private Font font;

    public J2dMenuState(J2dGraph gr, GameStateManager gsm) {
        super(gsm);
        this.gr = gr;

        try {
            bg = new Background(gr, "/Backgrounds/background.png");
            bg.setVector(0, 0.1);

            titleColor = new Color(0x34ebc6);
            titleFont = new Font("Century Gothic", Font.PLAIN, 60);

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

        //draw Background
        bg.draw();

        //draw Title
        g2d.setColor(titleColor);
        g2d.setFont(titleFont);
        g2d.drawString("Space Invaders", 65, 200);

        //draw menu
        g2d.setFont(font);
        for (int i = 0; i < getOptions().length; i++) {
            if (i == getCurrentChoice())
                g2d.setColor(Color.WHITE);
            else
                g2d.setColor(new Color(0x34ebc6));
            g2d.drawString(getOptions()[i], 260, 350 + i * 35);
        }
    }
}
