package org.erhmutlu.kata;

// Q2: ONE FRONT ONE BACK 123456 -> 162534
public class OneFrontOneBackCalculator {

    private static int solution(int A) {
        StringBuilder sb = new StringBuilder();
        if (A > 0) {
            char[] chars = String.valueOf(A).toCharArray();
            int length = chars.length;
            int middleIndex = Math.floorDiv(length, 2);
            for (int frontIndex = 0; frontIndex <= middleIndex; frontIndex++) {
                int backIndex = length - frontIndex - 1;
                sb.append(chars[frontIndex]);
                if (middleIndex < backIndex) {
                    sb.append(chars[backIndex]);
                }
            }
            return Integer.valueOf(sb.toString());
        } else if (A == 0) {
            return A;
        } else {
            // for negative numbers
            return solution(Math.abs(A)) * -1;
        }
    }
}
