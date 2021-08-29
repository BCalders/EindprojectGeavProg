package be.uantwerpen.fti.ei.bc.Graphics.Handlers;

import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Keyhandler, used to get inputs
 *
 * @author Bas Calders
 */
public class KeyHandler implements KeyListener {

    //keylist
    public static ArrayList<Key> keys = new ArrayList<>();

    /**
     * keys class, used in KeyHandler
     *
     * @author Bas Calders
     */
    public static class Key {
        private int presses, absorbs;
        public boolean isDown;
        private boolean isClicked;

        /**
         * key constructor and add to key list
         */
        public Key() {
            keys.add(this);
        }

        /**
         * toggle press
         *
         * @param isPressed if key is pressed
         */
        public void toggle(boolean isPressed) {
            if (isPressed != isDown) {
                isDown = isPressed;
            }
            if (isPressed) {
                presses++;
            }
        }

        /**
         * key click
         *
         * @return isclicked
         */
        public boolean isClicked() {
            if (isClicked) {
                isClicked = false;
                return true;
            } else
                return false;
        }

        /**
         * tick key
         */
        public void tick() {
            if (absorbs < presses) {
                absorbs++;
                isClicked = true;
            } else {
                isClicked = false;
            }
        }
    }

    //generate keys
    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key attack = new Key();
    public Key pause = new Key();
    public Key enter = new Key();
    public Key esc = new Key();
    public Key shift = new Key();
    public Key control = new Key();

    /**
     * keyhandler constructor
     *
     * @param gr graphics class
     */
    public KeyHandler(J2dGraph gr) {
        gr.getFrame().addKeyListener(this);
    }

    /**
     * release all keys
     */
    public void releaseAll() {
        for (Key i : keys) {
            i.isDown = false;
        }
    }

    /**
     * tick all keys
     */
    public void tick() {
        for (Key i : keys) {
            i.tick();
        }
    }

    /**
     * toggle a key
     *
     * @param e       keyevent
     * @param pressed isdown
     */
    public void toggle(KeyEvent e, boolean pressed) {
        if (e.getKeyCode() == KeyEvent.VK_UP) up.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) attack.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_P) pause.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_ENTER) enter.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) esc.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) shift.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) control.toggle(pressed);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //empty
    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);
        tick();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);
        tick();
    }
}
