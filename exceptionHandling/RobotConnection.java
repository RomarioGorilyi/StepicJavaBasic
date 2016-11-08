package exceptionHandling;

/**
 * Created by Roman Horilyi on 07.10.2016.
 */
public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close() throws Exception;
}
