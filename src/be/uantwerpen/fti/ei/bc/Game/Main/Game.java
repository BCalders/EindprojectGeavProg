package be.uantwerpen.fti.ei.bc.Game.Main;

import be.uantwerpen.fti.ei.bc.Game.Entities.TestSquare;
import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.Stopwatch.Stopwatch;
import be.uantwerpen.fti.ei.bc.Graphics.Main.KeyHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener { //Keylistner moet er nog uit

    private AFactory f;
    
    private boolean isRunning;

    private GraphicsClass graph;

    private GameStateManager gsm;

    private TestSquare ts;

    public Game(AFactory f) {
        this.f = f;
    }

    public void play() {

        long wait;
        Stopwatch s = new Stopwatch(60);

        isRunning = true;
        graph = f.createGraphicsClass();


        gsm = new GameStateManager(f);

        ts = f.createTS(50, 50, 0, 0);

        while (isRunning) {
            s.go();

            update();
            draw();
            graph.render();

            s.stop();
            wait = s.calculateWait();
            //System.out.println("waitTime = " + wait);
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void update() {
        gsm.update();
        ts.update();
    }

    private void draw() {
        gsm.draw();
        ts.draw();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        gsm.keyPressed(e.getKeyCode());
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gsm.keyReleased(e.getKeyCode());
    }
}
