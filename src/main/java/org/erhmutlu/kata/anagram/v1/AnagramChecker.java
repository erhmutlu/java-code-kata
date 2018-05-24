package org.erhmutlu.kata.anagram.v1;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramChecker {

    public static boolean isAnagram(String a, String b) {
        Map<Character, Long> letterFrequenciesForFirst = findFrequencies(a.toLowerCase());
        Map<Character, Long> letterFrequenciesForSecond = findFrequencies(b.toLowerCase());

        return hasSameFrequencies(letterFrequenciesForFirst, letterFrequenciesForSecond);
    }

    private static Map<Character, Long> findFrequencies(String word) {
        return word.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static boolean hasSameFrequencies(Map<Character, Long> frequencies1, Map<Character, Long> frequencies2) {
        if ((frequencies1.size() != frequencies2.size())) {
            return false;
        }
        return frequencies1
                .entrySet()
                .stream()
                .noneMatch(entry -> notContainsThatLetter(frequencies2, entry.getKey())|| hasNotSameFrequency(frequencies2, entry.getKey(), entry.getValue()));
    }

    private static boolean notContainsThatLetter(Map<Character, Long> letterFrequencies, Character letter) {
        return !letterFrequencies.containsKey(letter);
    }

    private static boolean hasNotSameFrequency(Map<Character, Long> letterFrequencies, Character letter, Long frequency) {
        return !letterFrequencies.get(letter).equals(frequency);
    }
}
