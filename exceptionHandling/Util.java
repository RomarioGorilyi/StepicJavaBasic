package exceptionHandling;

/**
 * Created by Roman Horilyi on 10.10.2016.
 */
public class Util {
    /**
     * Calculates square root of the specified number.
     * @param x number that is brought to the square root
     * @return square root of the specified number
     */
    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        } else {
            return Math.sqrt(x);
        }
    }
}
