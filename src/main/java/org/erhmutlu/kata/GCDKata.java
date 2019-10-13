package org.erhmutlu.kata;

import java.util.LinkedList;
import java.util.List;

public class GCDKata {

    public int generalizedGCD(int num, int[] arr) {
        int result = arr[0];
        for (int i = 1; i < num; i++)
            result = calculateGCD(arr[i], result);

        return result;
    }

    private int calculateGCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        return calculateGCD(b % a, a);
    }


    private List<Integer> findDivisors(int num) {
        List<Integer> divisors = new LinkedList<>();

        while (num % 2 == 0) {
            divisors.add(2);
            num /= 2;
        }

        for (int i = 3; i <= num; i += 2) {
            while (num % i == 0) {
                divisors.add(i);
                num /= i;
            }
        }
        return divisors;
    }

    public static void main(String[] args) {
        GCDKata GCDKata = new GCDKata();
        System.out.println(GCDKata.generalizedGCD(5, new int[]{10, 5, 6, 8, 20}));
    }

}
