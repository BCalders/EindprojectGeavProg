package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.LevelState;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;

public class J2dLevelState extends LevelState {

    private final J2dGraph gr;
    private Background bg;

    public J2dLevelState(J2dGraph graph, GameStateManager gsm, AFactory f) {
        super(gsm, f);
        this.gr = graph;
    }

    @Override
    public void init() {
        super.init();

        try {
            bg = new Background(gr, "/Backgrounds/background.png");
            bg.setVector(0, 2);
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

        //draw PlayerShip
        ps.draw();

        //draw enemy ships
        for (EnemyShip i : tempESs) {
            i.draw();
        }

        //draw Bullets
        tempBullet.draw();

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
        g2d.drawString(hudStrings[2], J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(hudStrings[2]) - 100, fontSize);

        for (int i = 0; i < 3; i++){
            g2d.dra
        }

    }
}
