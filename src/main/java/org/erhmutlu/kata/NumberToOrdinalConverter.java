package org.erhmutlu.kata;

public class NumberToOrdinalConverter {

    private static final String[] suffixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};

    public static String convert(Integer number) {
        if (number == 0) {
            return "0";
        }

        return findOrdinal(number);
    }

    private static String findOrdinal(Integer number) {
        switch (number % 100) {
            case 11:
            case 12:
            case 13:
                return number.toString() + "th";
            default:
                return number.toString() + suffixes[number % 10];
        }
    }
}
