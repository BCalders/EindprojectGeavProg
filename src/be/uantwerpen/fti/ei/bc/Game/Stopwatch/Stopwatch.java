package be.uantwerpen.fti.ei.bc.Game.Stopwatch;

/**
 * generic stopwatch class used to calculate elapsed time and wait to certain target time
 *
 * @author Bas Calders
 */
public class Stopwatch {

    //time vars
    private long start, stop, elapsed, targetTime;

    /**
     * constructor for stopwatch
     */
    public Stopwatch() {
    }

    /**
     * constructor of stopwatch
     *
     * @param tps calculation for certain ticks per second
     */
    public Stopwatch(int tps) {
        targetTime = 1000 / tps;
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

    /**
     * start stopwatch
     *
     * @return current time
     */
    public long go() {
        return start = System.currentTimeMillis();
    }

    /**
     * stop stopwatch
     *
     * @return elapsed time
     */
    public long stop() {
        elapsed = start - System.currentTimeMillis();
        stop = elapsed + start;
        return elapsed;
    }

    /**
     * calculate wait time to get certain tps
     *
     * @return waittime
     */
    public long calculateWait() {
        long wait = targetTime - elapsed;
        if (wait < 0)
            wait = 3;
        return wait;
    }
}
