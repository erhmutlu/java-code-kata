package org.erhmutlu.kata;

class CreditCard {

    private static final int MIN_DIGITS_COUNT = 6;
    private static final char MASK = '#';

    public static String maskify(String creditCardNumber) {
        String trimmedCreditCardNumber = creditCardNumber.trim();
        if (isInvalid(trimmedCreditCardNumber)) {
            return creditCardNumber;
        }
        return mask(trimmedCreditCardNumber);
    }

    private static boolean isInvalid(String creditCardNumber) {
        return creditCardNumber == null || creditCardNumber.length() < MIN_DIGITS_COUNT;
    }

    private static String mask(String creditCardNumber) {
        int length = creditCardNumber.length();

        char[] arr = creditCardNumber.toCharArray();
        for (int i = 0; i < length; i++) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                if (shouldMasked(i, length)) {
                    arr[i] = MASK;
                }
            }
        }
        return new String(arr);
    }

    private static boolean shouldMasked(int index, int lengthOfCreditCardNumber) {
        return isNotFirstIndex(index) && isNotOneOfLastFourIndexes(index, lengthOfCreditCardNumber);
    }

    private static boolean isNotFirstIndex(int index) {
        return index > 0;
    }

    private static boolean isNotOneOfLastFourIndexes(int index, int length) {
        return index < (length - 4);
    }
}
