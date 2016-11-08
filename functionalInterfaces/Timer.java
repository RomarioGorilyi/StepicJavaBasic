package functionalInterfaces;

/**
 * Created by Roman Horilyi on 29.09.2016.
 */
public class Timer {
    public long measureTime(Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();

        return System.currentTimeMillis() - startTime;
    }
}
