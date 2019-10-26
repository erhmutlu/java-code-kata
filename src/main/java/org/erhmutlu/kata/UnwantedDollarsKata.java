package org.erhmutlu.kata;

public class UnwantedDollarsKata {
    public static double moneyValue(String money) {
        if (money.chars().filter(Character::isDigit).count() == 0) {
            return 0;
        }

        String clearString = money.replaceAll("[$ ]+", "");
        return Double.valueOf(clearString);
    }
}
