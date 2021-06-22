package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bullet;
import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Graphics.KeyHandler.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class LevelState extends GameState {

    private final AFactory f;

    protected int score, lives;
    protected long levelStartTime;

    protected PlayerShip ps;
    protected LinkedList<EnemyShip> tempESs;
    protected Bullet tempBullet;

    public LevelState(GameStateManager gsm, AFactory f) {
        super(gsm);
        this.f = f;
//        init();
    }

    @Override
    public void init() {
        //init values
        lives = 3;
        score = 0;
        levelStartTime = System.currentTimeMillis();

        //init Entities
        this.ps = f.createPlayerShip();
        this.tempBullet = f.createBullet();
        tempESs = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            tempESs.add(f.createEnemyShip());
            tempESs.get(i).setPosition(-29 + 6 * i, -35);
        }

        ps.setPosition(0, 37);
        tempBullet.setPosition(0,0);

    }

    private void win(){
        int time = (int) Math.ceil(System.currentTimeMillis() - levelStartTime) / 1000;
        System.out.println("time: " + time);
        gsm.setScores(score, lives, time);
        gsm.setState(GameStateManager.WINSTATE);
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
//            tempESs.remove(5);
        }
        if(key.enter.isClicked()){
            System.out.println("ENTER WAS PRESSED");
            win();
        }
    }
}
