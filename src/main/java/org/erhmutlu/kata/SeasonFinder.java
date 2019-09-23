package org.erhmutlu.kata;

public class SeasonFinder {

    public static void main(String[] args) {

        int[] T = {-3, -14, -5, 7, 8, 42, 8, 3};
        System.out.println(solution(T));

        T = new int[]{2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3 , -18};
        System.out.println(solution(T));

        T = new int[]{-3, 12, -14, 2, -5, 7, 8, 41, 42, 8, 51, 3};
        System.out.println(solution(T));

        T = new int[]{-3, 12, 45, -14, 2, 12, -5, 7, 8, 41, 42, 8, 51, 3, 27, 0};
        System.out.println(solution(T));
    }

    public static String solution(int[] T) {
        int length = T.length;
        int seasonDaySize = length / 4;

        int[] amplitudes = new int[4];
        int min, max;

        if (T[0] > T[1]) {
            max = T[0];
            min = T[1];
        } else {
            max = T[1];
            min = T[0];
        }

        int season = 0;
        amplitudes[season] = max - min;
        for (int i = 2; i < length; i++) {
            if (i % seasonDaySize == 0) {
                season++;
                if (T[i] > T[i + 1]) {
                    max = T[i];
                    min = T[i + 1];
                } else {
                    max = T[i + 1];
                    min = T[i];
                }
                i++;
                amplitudes[season] = max - min;
                continue;
            }
            if (T[i] < min) {
                min = T[i];
            } else if (T[i] > max) {
                max = T[i];
            }
            amplitudes[season] = max - min;
        }

        int indexOfMaxAmp = 0;
        int maxAmp = amplitudes[indexOfMaxAmp];

        for (int i = 1; i < amplitudes.length; i++) {
            if (amplitudes[i] > maxAmp) {
                maxAmp = amplitudes[i];
                indexOfMaxAmp = i;
            }
        }

        if (indexOfMaxAmp == 0) {
            return "WINTER";
        } else if (indexOfMaxAmp == 1) {
            return "SPRING";
        } else if (indexOfMaxAmp == 2) {
            return "SUMMER";
        } else {
            return "AUTUMN";
        }
    }

}
