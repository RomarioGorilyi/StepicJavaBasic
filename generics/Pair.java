package generics;

/**
 * Created by Roman Horilyi on 22.10.2016.
 */
public class Pair<S, T> {
    /**
     * If non-null, the first; if null, indicates no value is present
     */
    private final S first;

    /**
     * If non-null, the second; if null, indicates no value is present
     */
    private final T second;

    private Pair(S sValue, T tValue) {
        this.first = sValue;
        this.second = tValue;
    }

    /**
     * Returns an {@code Pair} with the specified present first value and second value.
     *
     * @param <S> the class of the first value
     * @param <T> the class of the second value
     * @param sValue the first value to be present
     * @param tValue the second value to be present
     * @return an {@code Pair} with the first and second values present
     */
    public static <S, T> Pair<S, T> of(S sValue, T tValue) {
        return new Pair<S, T>(sValue, tValue);
    }

    public S getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
        return second != null ? second.equals(pair.second) : pair.second == null;

    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
