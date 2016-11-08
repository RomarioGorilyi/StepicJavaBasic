package util;

import java.util.function.DoubleUnaryOperator;

/**
 * Created by Roman Horilyi on 29.09.2016.
 */
public class Util {
    /**
     * Calculates an integral of the specified function with the specified low and high limits.
     * @param f function
     * @param a low limit
     * @param b high limit
     * @return integral
     */
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        int n = (int) ((b - a) * 10e5);
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += f.applyAsDouble(a + i * 10e-7) * ((a + (i + 1) * 10e-7) - (a + i * 10e-7));
            //result += f.applyAsDouble(a);
        }

        return result;
    }
}
