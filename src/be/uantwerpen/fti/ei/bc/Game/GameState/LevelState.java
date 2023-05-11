package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Game.Entities.*;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;
import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Main game class, all gameplay is handled in this class
 *
 * @author Bas Calders
 */
public abstract class LevelState extends GameState {
    //factory
    private final AFactory f;

    //enemy vars
    private boolean enemiesGoingRight, isAtEdge;
    private double speed;

    //gameplay vars
    protected int score, lives, time, hiScore = -1;
    protected long levelStartTime;

    //entities
    protected PlayerShip ps;
    protected ArrayList<EnemyShip> enemies;
    protected ArrayList<Bullet> bullets;
    protected ArrayList<Bonus> bonusses;

    /**
     * constructor of Levelstate
     *
     * @param gsm instance of the gamestatemanager
     * @param f   abstract factory to generate objects
     */
    public LevelState(GameStateManager gsm, AFactory f) {
        super(gsm);
        this.f = f;
    }

    /**
     * lose function
     */
    private void lose() {
        System.out.println("Time: " + time + " Lives: " + lives);
        gsm.setScores(score, lives, time);
        gsm.setState(GameStateManager.GAMEOVERSTATE);
    }

    /**
     * win function
     */
    private void win() {
        gsm.setScores(score, lives, time);
        gsm.setState(GameStateManager.WINSTATE);
    }

    /**
     * kill enemyship
     *
     * @param e          killed ship
     * @param multiplier points multiplyer if bonus
     */
    private void kill(EnemyShip e, int multiplier) {
        e.kill();
        score += 200 * multiplier;
    }

    /**
     * fire a bullet as the player
     */
    public void playerFire() {
        if (ps.canFire()) {
            ps.fire();
            Bullet b = f.createBullet();
            b.setPosition(ps.getX() + ps.getWidth() / 2 - b.getWidth() / 2, ps.getY());
            bullets.add(b);
        }
    }

    /**
     * fire a bullet as an enemy
     *
     * @param e enemy that fires
     */
    public void enemyShoot(EnemyShip e) {
        Bullet b = f.createBullet();
        b.setEnemyBullet();
        b.setPosition(e.getX() + e.getWidth() / 2 - b.getWidth() / 2, e.getY() - e.getHeight() / 2);
        bullets.add(b);
    }

    /**
     * spawn a bonus
     *
     * @param kind kind of the bonus
     * @param xLoc location on the x-axis
     */
    public void spawnBonus(int kind, int xLoc) {
        Bonus b = f.createBonus(kind);
        b.setPosition((xLoc - 27) / 10.0, 3.9);
        bonusses.add(b);
    }

    /**
     * spawn enemy Formation and add to enemy list
     */
    protected void spawnFormation() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                EnemyShip e = f.createEnemyShip(i);
                e.setPosition(-3 + 0.7 * j, 3.6 - 0.4 * i);
                enemies.add(e);
            }
        }
    }

    /**
     * read highscore from file
     *
     * @return highscore
     */
    private int readHiScore() {

        FileReader readFile;
        BufferedReader reader = null;

        try {
            readFile = new FileReader("src/be/uantwerpen/fti/ei/bc/Resources/Data/hiScore.dat");
            reader = new BufferedReader(readFile);
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File could not be read!");
            return -1;
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * init levelstate
     */
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
        isAtEdge = false;
        speed = 0.02;

        //init playership
        this.ps = f.createPlayerShip();
        ps.setPosition(0, -3.7);

        //init arrays
        bullets = new ArrayList<>();
        bonusses = new ArrayList<>();

        //get hiScore
        hiScore = readHiScore();
    }

    /**
     * update levelstate
     */
    @Override
    public void update() {
        time = (int) Math.ceil(System.currentTimeMillis() - levelStartTime) / 1000;
        Random r = new Random();
        int scoreMultiplyer = ps.isDouble() ? 2 : 1;

        //check for enemies outside playfield
        for (EnemyShip i : enemies) {
            if (i.detectEdge()) {
                isAtEdge = true;
                enemiesGoingRight = !enemiesGoingRight;
                speed += 0.0005;
                break;
            }
            // enemies reach destination
            if (i.getY() < -3.3) lose();
        }

        //update enemies
        for (int i = 0; i < enemies.size(); i++) {
            EnemyShip tempE = enemies.get(i);

            tempE.update();
            tempE.setSpeed(speed);

            if (isAtEdge) {
                tempE.setPosition(tempE.getX(), tempE.getY() - 0.1);
            }

            if (enemiesGoingRight) tempE.setVector(1, 0);
            else tempE.setVector(-1, 0);

            for (int j = 0; j < bullets.size(); j++) {
                if (tempE.intersects(bullets.get(j)) && !bullets.get(j).isEnemyBullet()) {
                    kill(tempE, scoreMultiplyer);
                    bullets.remove(j);
                    j--;
                }
            }

            if (tempE.shouldRemove()) {
                enemies.remove(i);
                i--;
                continue;
            }

            int shootRNG = 1900 - (80 * (24 - enemies.size()));
            if (r.nextInt(shootRNG) == 0) {
                enemyShoot(tempE);
            }
        }
        isAtEdge = false;

        //update playership
        ps.update();

        //update bullets
        for (int i = 0; i < bullets.size(); i++) {
            Bullet tempB = bullets.get(i);
            tempB.update();

            if (tempB.intersects(ps) && tempB.isEnemyBullet() && !ps.isFlinching()) {
                tempB.setHit();
                if (!ps.isShielded()) {
                    ps.hit();
                    lives--;
                    score -= 300;
                }
                ps.stopBonus();
            }

            if (tempB.shouldRemove()) {
                bullets.remove(i);
                i--;
            }
        }

        //Generate Bonus
        int bonusRNG = 2500;
        int rInt = r.nextInt(bonusRNG);
        if ((rInt < 4) && time > 9) {
            spawnBonus(rInt, r.nextInt(54));
            f.createBonus(rInt);
        }

        //update bonusses
        for (int i = 0; i < bonusses.size(); i++) {
            Bonus tempBo = bonusses.get(i);
            tempBo.update();

            if (tempBo.intersects(ps)) {
                tempBo.setHit();
                score += 1000 * scoreMultiplyer;
                ps.bonus(tempBo.getKind());
                if ((tempBo.getKind() == 2) && lives < 3) lives++;
                if (tempBo.getKind() == 3) {
                    for (EnemyShip j : enemies) {
                        j.setPosition(j.getX(), j.getY() + 0.5);
                    }
                }
            }

            if (tempBo.shouldRemove()) {
                bonusses.remove(i);
                i--;

            }
        }

        //end game if all enemies are destroyed
        if (enemies.isEmpty()) win();

        //end game if dead or time runs out
        if (lives <= 0) {    //100 - time <= 0
            lose();
        }

        //highscore is lower than actual score
        if (hiScore < score) hiScore = score;

    }

    public abstract void draw();

    /**
     * get inputs
     *
     * @param key inputted key
     */
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
            gsm.pauseState(this);
        }
        if (key.enter.isClicked()) {
            if (key.control.isDown) win();
            if (key.shift.isDown) lose();
        }
    }
}
