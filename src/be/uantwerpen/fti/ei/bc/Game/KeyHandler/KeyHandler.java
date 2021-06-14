package be.uantwerpen.fti.ei.bc.Game.KeyHandler;

import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyHandler implements KeyListener {

    public static ArrayList<Key> keys = new ArrayList<>();

    public class Key {
        public int presses, absorbs;
        public boolean isDown, isClicked;

        public Key() {
            keys.add(this);
        }

        public void toggle(boolean isPressed) {
            if (isPressed != isDown) {
                isDown = isPressed;
            }
            if (isPressed) {
                presses++;
            }
        }

        public boolean isClicked(){
            if (isClicked){
                isClicked = false;
                return true;
            }
            else
                return false;
        }

        public void tick() {
            if (absorbs < presses) {
                absorbs++;
                isClicked = true;
            } else {
                isClicked = false;
            }
        }
    }
    
    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key attack = new Key();
    public Key pause = new Key();
    public Key enter = new Key();
    public Key esc = new Key();

    public KeyHandler(J2dGraph gr) {
        gr.getFrame().addKeyListener(this);
    }

    public void releaseAll() {
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).isDown = false;
        }
    }

    public void tick() {
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).tick();
        }
    }

    public void toggle(KeyEvent e, boolean pressed){
        if(e.getKeyCode() == KeyEvent.VK_UP)
            up.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            down.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            left.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            right.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            attack.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_P)
            pause.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            enter.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
            esc.toggle(pressed);
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
