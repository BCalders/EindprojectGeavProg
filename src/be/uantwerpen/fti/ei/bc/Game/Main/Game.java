package be.uantwerpen.fti.ei.bc.Game.Main;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Stopwatch.Stopwatch;

/**
 * game class, starts and runs gameloop
 *
 * @author Bas Calders
 */
public class Game {

    //factory
    private final AFactory f;
    //gamestate<anager
    private GameStateManager gsm;

    /**
     * game constructor
     *
     * @param f abstract factory to generate objects
     */
    public Game(AFactory f) {
        this.f = f;
    }

    /**
     * main start function for game, includes gameloop
     */
    public void play() {

        long wait;
        Stopwatch s = new Stopwatch(60);

        boolean isRunning = true;
        GraphicsClass graph = f.createGraphicsClass();

        gsm = new GameStateManager(f);
        KeyHandler key = f.createKeyHandler();

        while (isRunning) {
            long start = s.go();

            input(key);
            update();
            draw();
            graph.render();

            s.stop();
            wait = s.calculateWait();
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double elapsed = (System.currentTimeMillis() - start) / 1000.0;
        }
        System.exit(2);
    }

    /**
     * update the gamestatemanager
     */
    private void update() {
        gsm.update();
    }

    /**
     * draw the gamestatemanager
     */
    private void draw() {
        gsm.draw();
    }

    /**
     * get inputs
     *
     * @param key inputted key
     */
    private void input(KeyHandler key) {
        gsm.input(key);
    }
}
