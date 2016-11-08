package functionalInterfaces;

import java.math.BigDecimal;

/**
 * Created by Roman Horilyi on 05.10.2016.
 */
public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        long time = timer.measureTime(new Runnable() {
            @Override
            public void run() {
                new BigDecimal("1234567").pow(100000);
            }
        });
        System.out.println(time);

        long timeNew = timer.measureTime(() -> new BigDecimal("1234567890").pow(1000000));
        System.out.println(timeNew);
    }
}
