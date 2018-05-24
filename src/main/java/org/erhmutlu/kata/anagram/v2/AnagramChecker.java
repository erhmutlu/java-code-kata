package org.erhmutlu.kata.anagram.v2;

import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {

    public static boolean isAnagram(String a, String b) {
        Map<Character, Integer> letterFrequenciesForFirst = findFrequencies(a.toLowerCase());
        Map<Character, Integer> letterFrequenciesForSecond = findFrequencies(b.toLowerCase());

        return hasSameFrequencies(letterFrequenciesForFirst, letterFrequenciesForSecond);
    }

    private static Map<Character, Integer> findFrequencies(String word) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char letter : word.toCharArray()) {
            if (frequencies.containsKey(letter)) {
                Integer count = frequencies.get(letter);
                frequencies.put(letter, ++count);
            } else {
                frequencies.put(letter, 1);
            }
        }
        return frequencies;
    }

    private static boolean hasSameFrequencies(Map<Character, Integer> letterFrequencies1, Map<Character, Integer> letterFrequencies2) {
        if ((letterFrequencies1.size() != letterFrequencies2.size())) {
            return false;
        }

        boolean notFound = false;
        for (Map.Entry<Character, Integer> entry : letterFrequencies1.entrySet()) {
            if (hasNotThatLetter(letterFrequencies2, entry.getKey())
                    || hasNotSameFrequency(letterFrequencies2, entry.getKey(), entry.getValue())) {
                notFound = true;
                break;
            }
        }
        return !notFound;
    }

    private static boolean hasNotSameFrequency(Map<Character, Integer> letterFrequencies, Character letter, Integer frequency) {
        return !letterFrequencies.get(letter).equals(frequency);
    }

    private static boolean hasNotThatLetter(Map<Character, Integer> letterFrequencies, Character letter) {
        return !letterFrequencies.containsKey(letter);
    }
}
