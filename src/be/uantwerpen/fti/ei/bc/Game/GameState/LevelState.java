package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Game.Entities.Bullet;
import be.uantwerpen.fti.ei.bc.Game.Entities.EnemyShip;
import be.uantwerpen.fti.ei.bc.Game.Entities.PlayerShip;
import be.uantwerpen.fti.ei.bc.Graphics.Entities.J2dBullet;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public abstract class LevelState extends GameState {

    private final AFactory f;

    private boolean enemiesGoingRight;

    protected int score, lives, time;
    protected long levelStartTime;

    protected PlayerShip ps;
    protected ArrayList<EnemyShip> enemies;
    protected ArrayList<Bullet> bullets;

    public LevelState(GameStateManager gsm, AFactory f) {
        super(gsm);
        this.f = f;
    }

    private void lose() {
        gsm.setScores(score, lives, time);
        gsm.setState(GameStateManager.GAMEOVERSTATE);
    }

    private void win() {
        gsm.setScores(score, lives, time);
        gsm.setState(GameStateManager.WINSTATE);
    }

    private void kill(EnemyShip e) {
        e.kill();
        score += 500;
    }

    public void playerFire() {
        if (ps.canFire()) {
            ps.fire();
            Bullet b = f.createBullet();
            b.setPosition(ps.getX() + ps.getWidth() / 2 - b.getWidth() / 2, ps.getY());
            bullets.add(b);
        }
    }

    public void enemyShoot(EnemyShip e) {
        Bullet b = f.createBullet();
        b.setEnemyBullet();
        b.setPosition(e.getX() + e.getWidth() / 2 - b.getWidth() / 2, e.getY() - e.getHeight() / 2);
        bullets.add(b);
    }

    protected void spawnFormation() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                EnemyShip e = f.createEnemyShip();
                e.setPosition(-4 + 0.4 * j, 3.6 - 0.4 * i);
                enemies.add(e);
            }
        }
    }

    @Override
    public void init() {
        //init values
        lives = 3;
        score = 0;
        levelStartTime = System.currentTimeMillis();

        //init Enemies
        enemies = new ArrayList<>();
        enemiesGoingRight = true;
        spawnFormation();
//        EnemyShip e = f.createEnemyShip();
//        e.setPosition(-1.5, 3.6);
//        enemies.add(e);

        //init playership
        this.ps = f.createPlayerShip();
        ps.setPosition(0, -3.7);

        //init bullets
        bullets = new ArrayList<>();
//        Bullet b = f.createBullet();
//        b.setPosition(0, 4);
//        b.setEnemyBullet();
//        bullets.add(b);
    }

    @Override
    public void update() {
        int currentSecond = (int) Math.ceil(System.currentTimeMillis() - levelStartTime) / 1000;
        time = 300 - currentSecond;
        Random r = new Random();

        //update enemies
        for (int i = 0; i < enemies.size(); i++) {
            EnemyShip tempE = enemies.get(i);

            if (enemiesGoingRight) tempE.setVector(1, 0);
            else tempE.setVector(-1, 0);

            tempE.update();

            for (Bullet j : bullets) {
                if (tempE.intersects(j) && !j.isEnemyBullet()) {
                    kill(tempE);
                }
            }

            if (tempE.shouldRemove()) {
                enemies.remove(i);
                System.out.println(tempE + " removed");
                i--;
                continue;
            }

            if (r.nextInt(100) == 0) {
                enemyShoot(tempE);
            }
        }

        //update playership
        ps.update();

        //update bullets
        for (int i = 0; i < bullets.size(); i++) {
            Bullet tempB = bullets.get(i);
            tempB.update();

            if (tempB.intersects(ps) && tempB.isEnemyBullet() && !ps.isFlinching()) {
                tempB.setHit();
                ps.hit();
                lives--;
            }

            if (tempB.shouldRemove()) {
                bullets.remove(i);
                System.out.println(tempB + " removed");
                i--;
            }
        }

        //end game if all enemies are destroyed
        if (enemies.isEmpty()) win();

        //end game if dead or time runs out
        if (time <= 0 || lives <= 0) {
            System.out.println("Time: " + time + " Lives: " + lives);
            lose();
        }

    }

    public abstract void draw();

    @Override
    public void input(KeyHandler key) {
        if (key.left.isDown) {
            ps.setVector(-1, 0);
        }
        if (key.right.isDown) {
            ps.setVector(1, 0);
        }
        if (!key.left.isDown && !key.right.isDown) {
            ps.setVector(0, 0);
        }
        if (key.attack.isClicked()) {
            playerFire();
        }
        if (key.pause.isClicked()) {
        }
        if (key.enter.isClicked()) {
            if (key.control.isDown) win();
            if (key.shift.isDown) lose();
        }
    }
}
