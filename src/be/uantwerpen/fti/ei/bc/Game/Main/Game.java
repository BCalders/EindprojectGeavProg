package be.uantwerpen.fti.ei.bc.Game.Main;

import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.KeyHandler.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Stopwatch.Stopwatch;

public class Game{

    private final AFactory f;

    private GameStateManager gsm;


    public Game(AFactory f) {
        this.f = f;
    }

    public void play() {

        long wait;
        Stopwatch s = new Stopwatch(60);

        boolean isRunning = true;
        GraphicsClass graph = f.createGraphicsClass();

        gsm = new GameStateManager(f);
        KeyHandler key = f.createKeyHandler();

        while (isRunning) {
            s.go();

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
        }

    }

    private void update() {
        gsm.update();
    }

    private void draw() {
        gsm.draw();
    }

    private void input(KeyHandler key){
        gsm.input(key);
    }
}
