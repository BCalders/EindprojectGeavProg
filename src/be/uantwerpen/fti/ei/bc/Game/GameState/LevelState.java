package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bullet;
import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Game.KeyHandler.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;

import java.util.ArrayList;

public abstract class LevelState extends GameState {

    private final AFactory f;
    protected PlayerShip ps;
    protected ArrayList<EnemyShip> tempESs;
    protected Bullet tempBullet;

    public LevelState(GameStateManager gsm, AFactory f) {
        this.gsm = gsm;
        this.f = f;
        init();
    }

    @Override
    public void init() {
        //init Entities
        this.ps = f.createPlayerShip();
        this.tempBullet = f.createBullet();
        tempESs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tempESs.add(f.createEnemyShip());
            tempESs.get(i).setPosition(-29 + 6 * i, -35);
        }
        ps.setPosition(0, 37);
        tempBullet.setPosition(0,0);
    }

    @Override
    public void update() {
    }

    public abstract void draw();

    public void shoot() {
        ps.shoot();
    }

    @Override
    public void input(KeyHandler key) {
        if (key.left.isDown) {
            ps.setDx(-ps.getSpeed());
        }
        if (key.right.isDown) {
            ps.setDx(ps.getSpeed());
        }
        if (!key.left.isDown && !key.right.isDown) {
            ps.setVector(0, 0);
        }
        if (key.attack.isClicked()) {
            shoot();
        }
        if (key.pause.isClicked()){
            tempESs.get(5).kill();
        }
    }
}
