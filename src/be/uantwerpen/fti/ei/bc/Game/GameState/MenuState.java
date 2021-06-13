package be.uantwerpen.fti.ei.bc.Game.GameState;

import java.awt.event.KeyEvent;

public abstract class MenuState extends GameState{

    private String[] options = {"Start", "Help", "Quit"};
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
    public void update() {

    }

    private void select(){
        if(currentChoice == 0){
            // start
            System.out.println("player pressed START!");
        }
        if(currentChoice == 1) {
            //help
            System.out.println("player pressed HELP!");
        }
        if(currentChoice == 2) {
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP){
            currentChoice--;
            currentChoice %= 3;
        }
        if(k == KeyEvent.VK_DOWN){
            currentChoice++;
            currentChoice %= 3;
        }
    }

    @Override
    public void keyReleased(int k) {

    }
}
