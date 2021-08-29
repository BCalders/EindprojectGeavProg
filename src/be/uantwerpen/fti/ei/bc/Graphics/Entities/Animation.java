package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import java.awt.image.BufferedImage;

/**
 * Animation class backbone of animation rendering
 *
 * @author Bas Calders
 */
public class Animation {

    //frame variables
    private BufferedImage[] frames;
    private int currentFrame;

    //time variables
    private long startTime;
    private long delay;

    /**
     * animation constructor
     */
    public Animation() {}

    public BufferedImage getFrame() {
        return frames[currentFrame];
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setFrames(BufferedImage[] frames) {
        this.frames = frames;
        currentFrame = 0;
        startTime = System.currentTimeMillis();
    }

    public void setDelay(int d) {
        this.delay = d;
    }

    public void setFrame(int i) {
        this.currentFrame = i;
    }

    /**
     * update animation
     */
    public void update() {
        if (delay == -1) return;

        long elapsed = System.currentTimeMillis() - startTime;
        if (elapsed > delay) {
            currentFrame++;
            startTime = System.currentTimeMillis();
        }
        if (currentFrame == frames.length) {
            currentFrame = 0;
        }
    }

}
