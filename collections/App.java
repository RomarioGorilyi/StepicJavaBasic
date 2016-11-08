package collections;

import java.util.*;

/**
 * Created by Roman Horilyi on 23.10.2016.
 */
public class App {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4, 5));
        Set<Integer> resultSet = symmetricDifference(set1, set2);
        resultSet.forEach(System.out::println);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set1Copy = new HashSet<>(set1);
        Set<T> set2Copy = new HashSet<>(set2);

        set1Copy.removeAll(set2);
        set2Copy.removeAll(set1);
        set1Copy.addAll(set2Copy);

        return set1Copy;
    }

    public static void manipulateInputIntegers() {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            scanner.nextInt();
            if (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
        }
        Collections.reverse(list);
        list.forEach(m -> System.out.print(m + " "));
    }
}
