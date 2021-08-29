package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

import java.io.*;

/**
 * state when won
 *
 * @author Bas Calders
 */
public abstract class WinState extends GameState {

    //scores
    protected String[] scoreNames;
    private int score, lives, time, totalScore;
    protected boolean isHighscore;

    /**
     * winstate constructor
     * @param gsm instance of gamestatemanger
     */
    public WinState(GameStateManager gsm) {
        super(gsm);
    }

    /**
     * read highscore from file
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
     * write highscore to file
     * @param score highscore value
     */
    private void setHiScore(int score) {
        File scoreFile = new File("src/be/uantwerpen/fti/ei/bc/Resources/Data/hiScore.dat");
        if (!scoreFile.exists()) {
            try {
                scoreFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter fileWriter;
        BufferedWriter writer = null;
        try {
            fileWriter = new FileWriter(scoreFile);
            writer = new BufferedWriter(fileWriter);
            writer.write("" + score);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * init winstate
     */
    @Override
    public void init() {
        scoreNames = new String[]{"Score: ", "Lives: ", "Time: ", "Total: "};
        int[] scores = gsm.getScores();
        score = scores[0];
        lives = scores[1];
        time = scores[2];
        totalScore = score + (lives * 1000) + ((60 - time) * 30);
        if (readHiScore() < totalScore) {
            setHiScore(totalScore);
            isHighscore = true;
        }
    }

    /**
     * calculate score
     * @return score
     */
    public String[] getScoreCalc() {
        String[] scoreCalc = new String[]{
                score + "",                 // om er een string van te maken
                lives + " x 1000",
                time + " x 30",
                totalScore + ""
        };
        return scoreCalc;
    }

    @Override
    public void update() {
    }

    @Override
    public abstract void draw();

    /**
     * get inputs
     *
     * @param key inputted key
     */
    @Override
    public void input(KeyHandler key) {
        if (key.enter.isClicked()) gsm.setState(GameStateManager.MENUSTATE);
    }
}
