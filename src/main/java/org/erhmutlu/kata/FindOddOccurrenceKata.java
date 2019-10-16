package org.erhmutlu.kata;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FindOddOccurrenceKata {

    public static int findIt(int[] a) {
        Map<Integer, Long> numberAndOccurrenceMapping = Arrays.stream(a)
                .boxed()
                .collect(groupingBy(Function.identity(), counting()));

        return numberAndOccurrenceMapping.entrySet()
                .stream()
                .filter(entry -> entry.getValue() % 2 == 1)
                .findFirst()
                .get()
                .getKey();
    }
}
