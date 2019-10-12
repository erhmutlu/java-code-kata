package org.erhmutlu.kata;

import java.util.HashMap;
import java.util.Map;


public class SmoothNumbersKata {
    /**
     * The concept of "smooth number" is applied to all those numbers whose prime factors are lesser than or equal to 7: 60 is a smooth number (2 * 2 * 3 * 5), 111 is not (3 * 37).
     *
     * More specifically, smooth numbers are classified by their highest prime factor and your are tasked with writing a isSmooth/is_smooth function that returns a string with this classification as it follows:
     *
     * 2-smooth numbers should be all defined as a "power of 2", as they are merely that;
     * 3-smooth numbers are to return a result of "3-smooth";
     * 5-smooth numbers will be labelled as "Hamming number"s (incidentally, you might appreciate this nice kata on them);
     * 7-smooth numbers are classified as "humble numbers"s;
     * for all the other numbers, just return non-smooth.
     * Examples:
     *
     * isSmooth(16) == "power of 2"
     * isSmooth(36) == "3-smooth"
     * isSmooth(60) == "Hamming number"
     * isSmooth(98) == "humble number"
     * isSmooth(111) == "non-smooth"
     * The provided input n is always going to be a positive number > 1.
     */

    private static Map<Long, String> smoothDecisionMapping;
    private static String NOT_SMOOTH = "non-smooth";

    static {
        smoothDecisionMapping = new HashMap<>();
        smoothDecisionMapping.put(2L, "power of 2");
        smoothDecisionMapping.put(3L, "3-smooth");
        smoothDecisionMapping.put(5L, "Hamming number");
        smoothDecisionMapping.put(7L, "humble number");
    }

    public static String isSmooth(long n) {
        long maximum = -1;
        if (isNumberDivisibleBy(n, 2)) {
            maximum = 2;
            n = divideInLoop(n, 2);
        }


        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (isNumberDivisibleBy(n, i)) {
                maximum = Math.max(maximum, i);
                n = divideInLoop(n, i);
            }
        }

        maximum = Math.max(maximum, n);
        return smoothDecisionMapping.getOrDefault(maximum, NOT_SMOOTH);
    }

    /**
     *
     * Better solution
     *
     */
    public static String isSmooth2(long n) {
        boolean[] isFactor = new boolean[8];
        for (int x : new int[]{2, 3, 5, 7})
            while (n % x < 1) {
                n /= x;
                isFactor[x] = true;
            }
        return n > 1 ? "non-smooth" :
                isFactor[7] ? "humble number" :
                        isFactor[5] ? "Hamming number" :
                                isFactor[3] ? "3-smooth" :
                                        "power of 2";
    }

    private static long divideInLoop(long n, int m) {
        while (isNumberDivisibleBy(n, m)) {
            n /= m;
        }
        return n;
    }

    private static boolean isNumberDivisibleBy(long n, int m) {
        return n % m == 0;
    }
}
