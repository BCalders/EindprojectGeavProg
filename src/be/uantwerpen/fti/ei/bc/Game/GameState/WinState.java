package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

import java.io.*;

public abstract class WinState extends GameState {

    protected String[] scoreNames;

    private int score, lives, time, totalScore;
    protected boolean isHighscore;


    public WinState(GameStateManager gsm) {
        super(gsm);
    }

    private int readHiScore() {

        FileReader readFile;
        BufferedReader reader = null;

        try {
            readFile = new FileReader("src/be/uantwerpen/fti/ei/bc/Resources/Highscores/hiScore.dat");
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

    private void setHiScore(int score) {
        File scoreFile = new File("src/be/uantwerpen/fti/ei/bc/Resources/Highscores/hiScore.dat");
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

    @Override
    public void input(KeyHandler key) {
        if (key.enter.isClicked()) gsm.setState(GameStateManager.MENUSTATE);
    }
}
