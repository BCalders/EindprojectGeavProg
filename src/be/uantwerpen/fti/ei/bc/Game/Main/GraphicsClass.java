package be.uantwerpen.fti.ei.bc.Game.Main;

public abstract class GraphicsClass {
    public abstract void render();
    public abstract double calculateX(double x);
    public abstract double calculateY(double y);
    public abstract double reformX(double x);
    public abstract double reformY(double y);
    public abstract void setFps(int fps, int ms);
}
