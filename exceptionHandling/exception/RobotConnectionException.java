package exceptionHandling.exception;

/**
 * Created by Roman Horilyi on 07.10.2016.
 */
public class RobotConnectionException extends RuntimeException {
    public RobotConnectionException(String message) {
        super(message);
    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
