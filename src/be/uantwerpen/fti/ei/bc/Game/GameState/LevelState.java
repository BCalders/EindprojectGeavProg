package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bullet;
import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;

import java.util.LinkedList;

public abstract class LevelState extends GameState {

    private final AFactory f;

    protected int score, lives, time;
    protected long levelStartTime;

    protected PlayerShip ps;
    protected LinkedList<EnemyShip> tempESs;
    protected Bullet tempBullet;

    public LevelState(GameStateManager gsm, AFactory f) {
        super(gsm);
        this.f = f;
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
            tempESs.get(i).setPosition(-3 + 0.4 * i, 3.5);
//            tempESs.get(i).setDx(0.05);
        }

        ps.setPosition(0, -3.7);
        tempBullet.setPosition(0,0);

    }

    private void lose(){
        gsm.setScores(score, lives, time);
        gsm.setState(GameStateManager.GAMEOVERSTATE);
    }

    private void win(){
        gsm.setScores(score, lives, time);
        gsm.setState(GameStateManager.WINSTATE);
    }

    private void kill(int i) {
        score += 500;
        tempESs.get(i).kill();
    }

    @Override
    public void update() {
        int currentSecond = (int) Math.ceil(System.currentTimeMillis() - levelStartTime) / 1000;
        time = 300 - currentSecond;

        //update Entities
        ps.update();
        for(EnemyShip i : tempESs){
            i.update();
        }

        //end game if dead or time runs out
        if(time <= 0 || lives <= 0) {
            System.out.println("Time: " + time +  " Lives: " + lives);
            lose();
        }

    }

    public abstract void draw();

    public void playerShoot() {
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
            playerShoot();
            lives--;                // ----------------- testing
        }
        if (key.pause.isClicked()){
            kill(5);             // ------------------ testing
//            tempESs.remove(5);
        }
        if(key.enter.isClicked()){
            if(key.control.isDown) win();
            if(key.shift.isDown) lose();
        }
    }
}
