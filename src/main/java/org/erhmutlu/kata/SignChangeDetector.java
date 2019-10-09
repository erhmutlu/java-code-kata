package org.erhmutlu.kata;

public class SignChangeDetector {

    public static int detect(int arr[]) {
        int length = arr.length;
        if (length == 0) {
            return 0;
        }

        int cnt = 0;
        boolean lastNegative = arr[0] < 0;
        for (int i = 1; i < length; i++) {
            boolean currentNegative = arr[i] < 0;
            if (currentNegative ^ lastNegative){
                lastNegative = currentNegative;
                cnt++;
            }
        }
        return cnt;
    }
}
