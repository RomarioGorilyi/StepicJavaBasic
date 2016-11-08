package streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Roman Horilyi on 31.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of();
        BiConsumer<Integer, Integer> biConsumer = (min, max) ->
                System.out.println("Min: " + min + "\nMax: " + max);
        findMinMax(stream, Integer::compare, biConsumer);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = new ArrayList<>(2);  // list to store Min and Max values of the specified stream
        stream.forEach(m -> {
            if (list.isEmpty()) {
                list.add(m);
                list.add(m);
            }
            if (order.compare(list.get(0), m) > 0) {
                list.set(0, m);
            } else if (order.compare(m, list.get(1)) > 0) {
                list.set(1, m);
            }
        });

        if (!list.isEmpty()) {
            minMaxConsumer.accept(
                    Optional.ofNullable(list.get(0)).orElse(null),
                    Optional.ofNullable(list.get(1)).orElse(null)
            );
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    /**
     * Finds 10 the most frequent words that are contained in {@code System.in}.
     * It's implied that a word is an every continuous succession of characters comprised only with letters and figures.
     * If there are less than 10 words in the text, all available are printed.
     * In case there are some words with the same frequency, they'll be placed in lexicographical order.
     */
    public static void findTenTheMostFrequentWordsInText() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> result = reader.lines()
              .map(s -> s.split("[\\s-]"))
              .flatMap(Arrays::stream)
              .map(s -> s.replaceAll("[\\p{Punct}]+", "").toLowerCase())
              .collect(
                      Collectors.groupingBy(
                              Function.identity(), Collectors.counting()
                      )
              );

        Map<String, Long> finalMap = new LinkedHashMap<>();
        result.entrySet().stream()
              .sorted(Map.Entry.comparingByKey(String.CASE_INSENSITIVE_ORDER))
              .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
              .limit(10)
              .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
    }
}
