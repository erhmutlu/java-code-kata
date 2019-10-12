package org.erhmutlu.kata;

import java.util.Arrays;

public class HistorgramKata {

    /**
     * A 6-sided die is rolled a number of times and the results are plotted as percentages in a character-based horizontal histogram.
     * <p>
     * Example:
     * <p>
     * 6|██ 5%
     * 5|
     * 4|███████ 15%
     * 3|███████████████████████████████████ 70%
     * 2|█ 3%
     * 1|███ 7%
     * Task
     * You will be passed the dice value frequencies, and your task is to write the code to return a string representing a histogram, so that when it is printed it has the same format as the example.
     * <p>
     * Notes
     * There are no trailing spaces on the lines
     * All lines (including the last) end with a newline \n
     * The percentage is displayed beside each bar except where it is 0%
     * The total number of rolls varies, but won't exceed 10,000
     * The bar lengths are scaled so that 100% = 50 x bar characters
     * The bar character is █, which is the Unicode U+2588 char
     * When calculating percentages and bar lengths always floor/truncate to the nearest integer
     */

    public static String histogram(final int results[]) {
        int length = results.length;

        Integer total = Arrays.stream(results)
                .boxed()
                .reduce(0, Integer::sum);

        int[] barCounts = new int[length];
        int[] percentageCounts = new int[length];
        for (int i = 0; i < length; i++) {
            int percentage = calculatePercentage(results[i], total);
            percentageCounts[i] = percentage;
            barCounts[i] = calculateBarCount(percentage);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = (percentageCounts.length - 1); i >= 0; i--) {
            sb.append(i + 1)
                    .append("|");
            for (int j = 0; j < barCounts[i]; j++) {
                sb.append("\u2588");
            }

            int percentage = percentageCounts[i];
            if (percentage > 0) {
                sb.append(" ")
                        .append(percentageCounts[i])
                        .append("%");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private static int calculatePercentage(int n, int total) {
        Double d1 = (double) n;
        Double d2 = (double) total;
        return (int) Math.floor(d1 * 100 / d2);
    }


    private static int calculateBarCount(int percentage) {
        Double d1 = (double) percentage;
        return (int) Math.floor(d1 / 2);
    }

    public static void main(String[] args) {
        System.out.println(histogram(new int[]{7, 3, 70, 15, 0, 5}));
    }

}
