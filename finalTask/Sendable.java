package finalTask;

/**
 * Created by Roman Horilyi on 08.11.2016.
 */
public interface Sendable<T> {
    String getFrom();

    String getTo();

    T getContent();
}
