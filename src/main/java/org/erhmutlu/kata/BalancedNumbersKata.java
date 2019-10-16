package org.erhmutlu.kata;

public class BalancedNumbersKata {

    public static String balancedNum(long number) {
        String numberStr = String.valueOf(number);

        int numberOfDecimal = numberStr.length();

        int mid = (int) Math.ceil((double) numberOfDecimal / 2);
        int leftEnd = mid - 1;
        int rightStart = numberOfDecimal % 2 == 0 ? (mid + 1) : mid;

        String left = numberStr.substring(0, leftEnd);
        String right = numberStr.substring(rightStart, numberOfDecimal);

        return calculateTotalOfDecimals(left) == calculateTotalOfDecimals(right) ? "Balanced" : "Not Balanced";
    }

    private static int calculateTotalOfDecimals(String str) {
        int total = 0;
        for (char c : str.toCharArray()) {
            total += (int) c;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(BalancedNumbersKata.balancedNum(413023L));
    }

}
