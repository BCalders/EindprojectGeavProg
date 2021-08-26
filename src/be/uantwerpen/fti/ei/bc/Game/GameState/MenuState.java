package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

public abstract class MenuState extends GameState{

    private String[] options = {"Start", "Quit Game"};
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
        super(gsm);
    }

    public void init(){
    }

    public abstract void draw();

    @Override
    public void update() {}

    private void select(){
        if(currentChoice == 0){
            // start
            gsm.setState(GameStateManager.LEVELSTATE);
        }
        if(currentChoice == 1) {
            gsm.exitGame("Player pressed Quit Game!");
        }
    }

    public void input(KeyHandler key){
        if(key.enter.isClicked())
            select();
        if(key.up.isClicked()){
            currentChoice--;
            if(currentChoice < 0)
                currentChoice = 1;
        }
        if(key.down.isClicked()){
            currentChoice++;
            if(currentChoice > 1)
                currentChoice = 0;
        }
    }
}
