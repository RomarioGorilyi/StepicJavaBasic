package util;

import static util.Util.*;

/**
 * Created by Roman Horilyi on 24.09.2016.
 */
public class TestUtil {
    public static void main(String[] args) {
        System.out.println(integrate(x -> 2, 0, 10));

        System.out.println(getCallerClassAndMethodName());

        System.out.println("----------------------------");
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod1();
    }

    private static void anotherMethod1() {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod2();
    }

    private static void anotherMethod2() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement[] traceElements = new Throwable().getStackTrace();
        int length = traceElements.length;

        /*for (StackTraceElement element : traceElements) {
            System.out.println(element);
        }*/

        if (length >= 3) {
            stringBuilder.append(traceElements[1].getClassName())
                    .append("#")
                    .append(traceElements[1].getMethodName());

            return stringBuilder.toString();
        } else {
            return null;
        }
    }
}
