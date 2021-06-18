package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Game.KeyHandler.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;

import static java.lang.Math.abs;

public abstract class LevelState extends GameState {

    private final AFactory f;
    protected PlayerShip p;

    public LevelState(GameStateManager gsm, AFactory f) {
        this.gsm = gsm;
        this.f = f;
        init();
    }

    @Override
    public void init() {
        this.p = f.createPlayerShip();
        p.setPosition(0, 37);
    }

    @Override
    public void update() {

    }

    public abstract void draw();

    @Override
    public void input(KeyHandler key) {
//        if(key.left.isDown){
//            p.setVector(-1,0);
//        }
//        if(key.right.isDown){
//            p.setVector(1,0);
//        }
//    }

        // test stoppen in het midden
//        double newVect, threshold = 0.009, epsilon = 0.002;
//        if (key.left.isClicked) {
//            if (p.getDx() < 1) {
//                newVect = p.getDx() - 0.01;
//                System.out.println("abs newvect: " + abs(newVect) + " verschil: " + abs(newVect + threshold));
//                if (abs(newVect + threshold) < epsilon) {
//                    p.setVector(newVect, p.getDy());
//                } else
//                    p.setVector(0, 0);
//            }
//        }
//        if (key.right.isClicked) {
//            if (p.getDx() > -1) {
//                newVect = p.getDx() + 0.01;
//                if (abs(newVect - threshold) < epsilon) {
//                    p.setVector(newVect, p.getDy());
//                } else
//                    p.setVector(0, 0);
//
//            }
//        }
//        System.out.println("dx is nu: " + p.getDx());
//    }
//
//        double newVect = 0, dx;
//        dx = p.getDx();
//        if (key.left.isDown) {
//            if (p.getDx() < 1) {
//                newVect = dx - 0.005;
//            }
//        }
//        if (key.right.isDown) {
//            if (p.getDx() < 1) {
//                newVect = dx + 0.005;
//            }
//        }
//        if (abs(newVect) < 0.001) {
//            p.setVector(p.getDx() <= 0.001 ? p.getDx() - 0.1 : 0, p.getDy());
//        } else
//            p.setVector(newVect, p.getDy());
//        System.out.println("dx: " + dx);
    }
}
