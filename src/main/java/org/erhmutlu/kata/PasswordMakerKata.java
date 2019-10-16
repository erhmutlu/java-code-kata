package org.erhmutlu.kata;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PasswordMakerKata {

    /**
     * Background
     * Different sites have different password requirements.
     * <p>
     * You have grown tired of having to think up new passwords to meet all the different rules, so you write a small piece of code to do all the thinking for you.
     * <p>
     * Kata Task
     * Return any valid password which matches the requirements.
     * <p>
     * Input:
     * <p>
     * len = password must be this length
     * flagUpper = must (or must not) contain UPPERCASE alpha
     * flagLower = must (or must not) contain lowercase alpha
     * flagDigit = must (or must not) contain digit
     * Notes
     * Only alpha-numeric characters are permitted
     * The same character cannot occur more than once in the password!
     * All test cases guarantee that a valid password is possible
     */

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final Random random = new Random();

    public static String makePassword(int len, boolean flagUpper, boolean flagLower, boolean flagDigit) {
        List<List<String>> rules = new LinkedList<>();
        if (flagUpper) {
            List<String> upper = new LinkedList<>(Arrays.asList(CHAR_UPPER.split("")));
            Collections.shuffle(upper);
            rules.add(upper);
        }

        if (flagLower) {
            List<String> lower = new LinkedList<>(Arrays.asList(CHAR_LOWER.split("")));
            Collections.shuffle(lower);
            rules.add(lower);
        }

        if (flagDigit) {
            List<String> number = new LinkedList<>(Arrays.asList(NUMBER.split("")));
            Collections.shuffle(number);
            rules.add(number);
        }

        List<Integer> indexes = IntStream.range(0, len).boxed().collect(Collectors.toList());
        Collections.shuffle(indexes);

        String[] password = new String[len];
        for (int i = 0; i < len; i++) {
            int ruleNumber = i < rules.size() ? i : randomInt(rules.size());
            List<String> rule = rules.get(ruleNumber);

            Integer targetIndex = indexes.get(i);
            password[targetIndex] = rule.remove(0);

            if (rule.size() == 0) {
                rules.remove(ruleNumber);
            }
        }

        return String.join("", password);
    }

    private static int randomInt(int limit) {
        return random.nextInt(limit);
    }

    public static void main(String[] args) {
        System.out.println(makePassword(5, true, true, false));
    }
}
