package be.uantwerpen.fti.ei.bc.Game.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Handlers.KeyHandler;

/**
 * Menu of the game
 *
 * @author Bas Calders
 */
public abstract class MenuState extends GameState {

    //options vars
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

    /**
     * menustate constructor
     *
     * @param gsm instance of the gamestatemanager
     */
    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
    }

    public abstract void draw();

    @Override
    public void update() {
    }

    /**
     * select a choice in the menu
     */
    private void select() {
        if (currentChoice == 0) {
            // start
            gsm.setState(GameStateManager.LEVELSTATE);
        }
        if (currentChoice == 1) {
            gsm.exitGame("Player pressed Quit Game!");
        }
    }

    /**
     * get inputs
     *
     * @param key inputted key
     */
    public void input(KeyHandler key) {
        if (key.enter.isClicked())
            select();
        if (key.up.isClicked()) {
            currentChoice--;
            if (currentChoice < 0)
                currentChoice = 1;
        }
        if (key.down.isClicked()) {
            currentChoice++;
            if (currentChoice > 1)
                currentChoice = 0;
        }
    }
}
