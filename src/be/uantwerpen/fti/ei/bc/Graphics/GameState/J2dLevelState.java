package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bullet;
import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.LevelState;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;
import be.uantwerpen.fti.ei.bc.Graphics.Entities.J2dEnemyShip;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.TextureHandler;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;
import java.awt.image.BufferedImage;

public class J2dLevelState extends LevelState {

    private final J2dGraph gr;

    private BufferedImage livesTexture;

    public J2dLevelState(J2dGraph graph, GameStateManager gsm, AFactory f) {
        super(gsm, f);
        this.gr = graph;
    }

    @Override
    public void init() {
        J2dEnemyShip.loadsprites();
        super.init();
        J2dGraph.bg.setVector(0, 2);
        livesTexture = TextureHandler.getPlayershipTexture();
    }

    @Override
    public void update() {
        super.update();
        J2dGraph.bg.update();
    }

    @Override
    public void draw() {
        Graphics2D g2d = gr.getG2d();

        //draw Background
        J2dGraph.bg.draw();

        //draw PlayerShip
        ps.draw();

        //draw enemy ships
        for (EnemyShip i : enemies) {
            i.draw();
        }

        //draw Bullets
        for (Bullet i : bullets) {
            i.draw();
        }

        //draw HUD
        int fontSize = 25;
        Color hudColor = new Color(0, 255, 180);
        Font hudFont = new Font("Arial", Font.PLAIN, fontSize);
        g2d.setColor(hudColor);
        g2d.setFont(hudFont);

        String[] hudStrings = new String[]{
                "Time: " + time + " sec",
                "Score: " + score,
                "Lives: "
        };

        g2d.drawString(hudStrings[0], 5, fontSize);
        g2d.drawString(hudStrings[1], J2dGraph.WIDTH / 2 - g2d.getFontMetrics(g2d.getFont()).stringWidth(hudStrings[1]) / 2, fontSize);
        g2d.drawString(hudStrings[2], J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(hudStrings[2]) - ((int) gr.reformX(ps.getcWidth()) + 10) * 3, fontSize);

        g2d.setColor(Color.GREEN);

        for (int i = 0; i < lives; i++) {
            g2d.drawImage(livesTexture, J2dGraph.WIDTH - ((int) gr.reformX(ps.getcWidth()) + 13) * (3 - i), 7, (int) gr.reformX(ps.getWidth()), (int) gr.reformY(ps.getHeight()), null);
        }

    }
}
