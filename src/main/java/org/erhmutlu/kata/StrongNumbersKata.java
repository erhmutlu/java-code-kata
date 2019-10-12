package org.erhmutlu.kata;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class StrongNumbersKata {

    /**
     * Strong number is the number that the sum of the factorial of its digits is equal to number itself.
     * <p>
     * For example: 145, since
     * 1! + 4! + 5! = 1 + 24 + 120 = 145
     * So, 145 is a Strong number.
     */

    public static String isStrongNumber(int num) {
        return findSumOfFacts(num) == num ? "STRONG!!!!" : "Not Strong !!";
    }

    public static String isStrongNumber2(int num) {
        return isStrong(num) ? "STRONG!!!!" : "Not Strong !!";
    }

    private static boolean isStrong(final int num) {
        return String.valueOf(num).chars().map(toDigit).map(factorial).sum() == num;
    }

    private static IntUnaryOperator toDigit = c -> Character.digit(c, 10);
    private static IntUnaryOperator factorial = d -> IntStream.rangeClosed(1, d).reduce(1, (a, b) -> a * b);

    private static int findSumOfFacts(int num) {
        String number = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Character.digit(number.charAt(i), 10);
            sum += fact(digit);
        }

        return sum;
    }

    private static int fact(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
