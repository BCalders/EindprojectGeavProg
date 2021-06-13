package be.uantwerpen.fti.ei.bc.Game.Stopwatch;

public class Stopwatch {

    private long start, stop, elapsed, targetTime;
    private int FPS;

    public Stopwatch(){}

    public Stopwatch(int fps){
        FPS = fps;
        targetTime = 1000/FPS;
    }

    public long getStart() {
        return start;
    }

    public long getStop() {
        return stop;
    }

    public long getElapsed() {
        return elapsed;
    }

    public long go(){
        return start = System.currentTimeMillis();
    }

    public long stop(){
        elapsed = start - System.currentTimeMillis();
        stop = elapsed + start;
        return elapsed;
    }

    public long calculateWait(){
        long wait = targetTime - elapsed;
        if (wait < 0)
            wait = 3;
        return wait;
    }
}
