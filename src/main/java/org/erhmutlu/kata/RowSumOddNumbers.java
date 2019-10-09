package org.erhmutlu.kata;

public class RowSumOddNumbers {

    /**
     * Given the triangle of consecutive odd numbers:
     *
     *              1
     *           3     5
     *        7     9    11
     *    13    15    17    19
     * 21    23    25    27    29
     * ...
     * Calculate the row sums of this triangle from the row index (starting at index 1) e.g.:
     *
     * rowSumOddNumbers(1); // 1
     * rowSumOddNumbers(2); // 3 + 5 = 8
     * @param n
     * @return
     */

    public static int sumOfOddNumbersRow(int n) {

        /**
         *
         * first number in nth row is 2x+1 which is
         * x : total number before (n-1) ->
         *          n:3 -> 2,1 -> 3 ->>> 2*3 + 1 = 7
         *          n:4 -> 3,2,1 -> 6 ->>> 2*6+1 = 13
         *
         * last number in nth row is firstNumber + 2 * (n-1)
         *          n:3, firstNumber -> 7 + 2 * (2) -> 11
         *          n:4, firstNumber -> 13 + 2 * (3) -> 19
         *
         *
         * total of odd numbers between 1..x -> x * x
         */

        int firstNumber = 2 * calculateTotalOfNumbers(n - 1) + 1;
        int lastNumber = firstNumber + 2 * (n - 1);
        return calculateTotalOfOddNumbers(lastNumber) - calculateTotalOfOddNumbers(firstNumber - 1);
    }

    private static int calculateTotalOfNumbers(int n) {
        return n * (n + 1) / 2;
    }

    private static int calculateTotalOfOddNumbers(int n) {
        n = (n + 1) / 2;
        return n * n;
    }
}
