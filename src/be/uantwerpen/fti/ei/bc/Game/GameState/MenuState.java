package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Game.KeyHandler.KeyHandler;

public abstract class MenuState extends GameState{

    private String[] options = {"Start", "Highscores", "Quit"};
    private int currentChoice = 0;

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getCurrentChoice() {
        return currentChoice;
    }

    public void setCurrentChoice(int currentChoice) {
        this.currentChoice = currentChoice;
    }

    public MenuState(GameStateManager gsm){
        this.gsm = gsm;
    }

    public void init(){

    }

    public abstract void draw();

    @Override
    public void update() {}

    private void select(){
        if(currentChoice == 0){
            // start
            System.out.println("player pressed START!");
            gsm.setState(GameStateManager.LEVELSTATE);
        }
        if(currentChoice == 1) {
            //help
            System.out.println("player pressed HIGHSCORES!");
        }
        if(currentChoice == 2) {
            gsm.exitGame("Player pressed Quit Game!");
        }
    }

    public void input(KeyHandler key){
        if(key.enter.isClicked())
            select();
        if(key.up.isClicked()){
            currentChoice--;
            if(currentChoice < 0)
                currentChoice = 2;
        }
        if(key.down.isClicked()){
            currentChoice++;
            if(currentChoice > 2)
                currentChoice = 0;
        }
    }
}
