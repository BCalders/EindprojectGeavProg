package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Game.KeyHandler.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;

import static java.lang.Math.abs;

public abstract class LevelState extends GameState {

    private final AFactory f;
    protected PlayerShip ps;

    public LevelState(GameStateManager gsm, AFactory f) {
        this.gsm = gsm;
        this.f = f;
        init();
    }

    @Override
    public void init() {
        this.ps = f.createPlayerShip();
        ps.setPosition(0, 37);
    }

    @Override
    public void update() {

    }

    public abstract void draw();

    @Override
    public void input(KeyHandler key) {
        if (key.left.isDown) {
            ps.setVector(-ps.getSpeed(), 0);
        }
        if (key.right.isDown) {
            ps.setVector(ps.getSpeed(), 0);
        }
        if (!key.left.isDown && !key.right.isDown){
            ps.setVector(0,0);
        }
        if (key.attack.isClicked()){
            ps.shoot();
        }
    }
}
