package logging;

import java.util.logging.*;

/**
 * Created by Roman Horilyi on 07.10.2016.
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Logger.class.getName());

    public static void main(String[] args) {
        //LOGGER.setLevel(Level.WARNING);
        LOGGER.log(Level.INFO, "I'm logging"); // SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST
        LOGGER.warning("We have a problem!");

        int x = 1996;
        LOGGER.log(Level.FINEST, "Current value of x is " + x); // Even when level is higher, our program will make
                                                                // concatenation of Strings and this process is
                                                                // recourse-demanding.
        LOGGER.log(Level.FINEST, "Current value of x is {0}", x);

        int y = 2016;
        LOGGER.log(Level.FINEST, "Point coordinates are ({0}, {1})", new Object[] {x, y});

        Exception e = new Exception();
        LOGGER.log(Level.SEVERE, "Unexpected exception", e);
    }

    /*  Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
        Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
        Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности
        сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях
        "org.stepic", "org" и "".*/
    private static void configureLogging() {
        Logger.getLogger("org.stepic.java.logging.ClassA").setLevel(Level.ALL);

        Logger.getLogger("org.stepic.java.logging.ClassB").setLevel(Level.WARNING);

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());
        Logger logger = Logger.getLogger("org.stepic.java");
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
    }
}
