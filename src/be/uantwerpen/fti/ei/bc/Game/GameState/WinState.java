package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

public abstract class WinState extends GameState {

    protected String[] scoreNames;

    private int score, lives, time, totalScore;


    public WinState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        scoreNames = new String[]{"Score: ", "Lives: ", "Time: ", "Total: "};
        int[] scores = gsm.getScores();
        score = scores[0];
        lives = scores[1];
        time = scores[2];
        totalScore = score + (lives * 100) + (time * 10);
    }

    public String[] getScoreCalc(){
        String[] scoreCalc = new String[]{
                score + "",                 // om er een string van te maken
                lives + " x 100",
                (100 - time) + " x 10",
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
        if(key.enter.isClicked()) gsm.setState(GameStateManager.MENUSTATE);
    }
}
