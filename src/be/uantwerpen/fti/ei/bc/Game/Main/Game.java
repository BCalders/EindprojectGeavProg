package be.uantwerpen.fti.ei.bc.Game.Main;

import be.uantwerpen.fti.ei.bc.Game.Entities.TestSquare;
import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.Stopwatch.Stopwatch;
import be.uantwerpen.fti.ei.bc.Game.KeyHandler.KeyHandler;

public class Game{

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
        KeyHandler key = f.createKeyHandler();

        ts = f.createTS(50, 50, 0, 0);

        while (isRunning) {
            s.go();

            input(key);
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

    private void input(KeyHandler key){
        gsm.input(key);
    }
}
