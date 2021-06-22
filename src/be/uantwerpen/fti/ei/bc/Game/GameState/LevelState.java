package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bullet;
import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class LevelState extends GameState {

    private final AFactory f;

    protected int score, lives, time;
    protected long levelStartTime;

    protected PlayerShip ps;
    protected LinkedList<EnemyShip> tempESs;
    protected ArrayList<Bullet> bullets;

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

        //init Enemies
        tempESs = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            tempESs.add(f.createEnemyShip());
            tempESs.get(i).setPosition(-3 + 0.4 * i, 3.5);
            tempESs.get(i).setVector(1, 0);
        }

        //init playership
        this.ps = f.createPlayerShip();
        ps.setPosition(0, -3.7);

        //init bullets
        bullets = new ArrayList<>();
    }

    private void lose() {
        gsm.setScores(score, lives, time);
        gsm.setState(GameStateManager.GAMEOVERSTATE);
    }

    private void win() {
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

        //update enemies
        for (EnemyShip i : tempESs) {
            i.update();
        }

        //update playership
        ps.update();

        //update bullets
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();
            if (bullets.get(i).shouldRemove()) {
                System.out.println(bullets.get(i) + " Will be removed");
                bullets.remove(i);
                i--;
            }
        }

        //end game if dead or time runs out
        if (time <= 0 || lives <= 0) {
            System.out.println("Time: " + time + " Lives: " + lives);
            lose();
        }

    }

    public abstract void draw();

    public void playerFire() {
        if (ps.canFire()) {
            ps.fire();
            Bullet b = f.createBullet();
            b.setPosition(ps.getX() + ps.getWidth() / 2, ps.getY());
            bullets.add(b);
        }
    }

    public void enemyShoot(EnemyShip e) {
        Bullet b = f.createBullet();
        b.setEnemyBullet();
        b.setPosition(e.getX() + e.getWidth() / 2, e.getY());
        bullets.add(b);
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
            playerFire();
//            lives--;                // ----------------- testing
        }
        if (key.pause.isClicked()) {
            kill(5);             // ------------------ testing
//            tempESs.remove(5);
        }
        if (key.enter.isClicked()) {
            if (key.control.isDown) win();
            if (key.shift.isDown) lose();
        }
    }
}
