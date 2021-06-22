package be.uantwerpen.fti.ei.bc.Graphics.Entities;

import java.awt.image.BufferedImage;

public class Animation {

    private BufferedImage[] frames;
    private int currentFrame;

    private long startTime;
    private long delay;

    private boolean playedOnce;

    public Animation() {
        playedOnce = false;
    }

    public BufferedImage getFrame() {
        return frames[currentFrame];
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public boolean hasPlayedOnce() {
        return playedOnce;
    }

    public void setFrames(BufferedImage[] frames) {
        this.frames = frames;
        currentFrame = 0;
        startTime = System.currentTimeMillis();
        playedOnce = false;
    }

    public void setDelay(int d) {
        this.delay = d;
    }

    public void setFrame(int i) {
        this.currentFrame = i;
    }

    public void update() {
        if (delay == -1) return;

        long elapsed = System.currentTimeMillis() - startTime;
        if (elapsed > delay) {
            currentFrame++;
            startTime = System.currentTimeMillis();
        }
        if (currentFrame == frames.length) {
            currentFrame = 0;
            playedOnce = true;
        }
    }

}
