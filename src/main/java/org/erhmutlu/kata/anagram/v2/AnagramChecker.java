package org.erhmutlu.kata.anagram.v2;

import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {

    public static boolean isAnagram(String word1, String word2) {
        Map<Character, Integer> letterFrequenciesForFirst = findLetterFrequencies(word1.toLowerCase());
        Map<Character, Integer> letterFrequenciesForSecond = findLetterFrequencies(word2.toLowerCase());

        return hasSameFrequencies(letterFrequenciesForFirst, letterFrequenciesForSecond);
    }

    private static Map<Character, Integer> findLetterFrequencies(String word) {
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
            if (notContainsThatLetter(letterFrequencies2, entry.getKey())
                    || hasNotSameFrequency(letterFrequencies2, entry.getKey(), entry.getValue())) {
                notFound = true;
                break;
            }
        }
        return !notFound;
    }

    private static boolean notContainsThatLetter(Map<Character, Integer> letterFrequencies, Character letter) {
        return !letterFrequencies.containsKey(letter);
    }

    private static boolean hasNotSameFrequency(Map<Character, Integer> letterFrequencies, Character letter, Integer frequency) {
        return !letterFrequencies.get(letter).equals(frequency);
    }

}
