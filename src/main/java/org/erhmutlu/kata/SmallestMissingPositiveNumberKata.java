package org.erhmutlu.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SmallestMissingPositiveNumberKata {

    /**
     * Write a function:
     *
     * class Solution { public int solution(int[] A); }
     *
     * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
     *
     * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
     *
     * Given A = [1, 2, 3], the function should return 4.
     *
     * Given A = [−1, −3], the function should return 1.
     *
     * Write an efficient algorithm for the following assumptions:
     *
     * N is an integer within the range [1..100,000];
     * each element of array A is an integer within the range [−1,000,000..1,000,000].
     *
     */

    public int solution(int[] A) {
        List<Integer> sortedPositiveNumbers = Arrays.stream(A)
                .boxed()
                .filter(number -> number > 0)
                .sorted()
                .collect(Collectors.toList());

        if (sortedPositiveNumbers.size() == 0 || sortedPositiveNumbers.get(0) > 1) {
            return 1;
        }

        int result = 0;
        for (int i = 1; i < sortedPositiveNumbers.size(); i++) {
            int previous = sortedPositiveNumbers.get(i - 1);
            int current = sortedPositiveNumbers.get(i);

            if (current - previous > 1) {
                result = previous + 1;
                break;
            }
        }

        return result != 0 ? result : sortedPositiveNumbers.get(sortedPositiveNumbers.size() - 1) + 1;
    }
}
