package be.uantwerpen.fti.ei.bc.Graphics.Main;

public class Config {
    private int HEIGHT, WIDTH;
    private float SFXVOL, MVOL;

    public Config() {
    }

    public Config(int HEIGHT, int WIDTH, float SFXVOL, float MVOL) {
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
        this.SFXVOL = SFXVOL;
        this.MVOL = MVOL;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public float getSFXVOL() {
        return SFXVOL;
    }

    public void setSFXVOL(float SFXVOL) {
        this.SFXVOL = SFXVOL;
    }

    public float getMVOL() {
        return MVOL;
    }

    public void setMVOL(float MVOL) {
        this.MVOL = MVOL;
    }
}
