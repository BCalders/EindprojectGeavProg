package be.uantwerpen.fti.ei.bc.Graphics.GameState;

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

        try {
            bg = new Background(gr, "/Backgrounds/background.png");
            bg.setVector(0, 2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        super.update();
        bg.update();
        p.update();;
    }

    @Override
    public void draw() {
        Graphics2D g2d = gr.getG2d();

        //draw Background
        bg.draw();

        //draw PlayerShip
        p.draw();

        g2d.setColor(Color.RED);
        g2d.fillRect(550, 25, 25, 25); // to show game didnt crash
    }
}
