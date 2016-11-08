package exceptionHandling;

import exceptionHandling.exception.RobotConnectionException;

/**
 * Created by Roman Horilyi on 07.10.2016.
 */
public class Application {
    public static void main(String[] args) {
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) throws Exception {
        int attemptsCounter = 0;
        boolean completed = false;

        while ((completed == false) && (attemptsCounter < 3)) {
            attemptsCounter++;
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                completed = true;
            } catch (RobotConnectionException rce) {

            } catch (Exception e) {
                throw e;
            }
        }

        if (completed == false) {
            throw new RobotConnectionException("Connection error. 3 attempts to get connection with robot failed.");
        }
    }
}
