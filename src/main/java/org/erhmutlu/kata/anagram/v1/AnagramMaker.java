package org.erhmutlu.kata.anagram.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramMaker {

    public static int calculateDiffCount(String a, String b) {
        Map<Character, Integer> characterFrequencies1 = findCharacterFrequencies(a);
        Map<Character, Integer> characterFrequencies2 = findCharacterFrequencies(b);

        return calculateDiffCount(characterFrequencies1, characterFrequencies2);
    }

    private static Map<Character, Integer> findCharacterFrequencies(String str) {
        Map<Character, Integer> characterFrequencyMap = str.chars()
                .mapToObj(e -> (char) e)
                .collect((Collectors.toMap(w -> w, w -> 1, Integer::sum)));

        return characterFrequencyMap;
    }

    private static int calculateDiffCount(Map<Character, Integer> characterFrequencies1, Map<Character, Integer> characterFrequencies2) {
        Map<Character, Integer> copyOfcharacterFrequencies2 = new HashMap<>(characterFrequencies2);

        int diff = 0;
        for (Map.Entry<Character, Integer> entry : characterFrequencies1.entrySet()) {
            Character character = entry.getKey();
            Integer frequencyIn1 = entry.getValue();
            Integer frequencyIn2 = pop(copyOfcharacterFrequencies2, character, 0);
            diff += Math.abs(frequencyIn1 - frequencyIn2);
        }

        int frequencyOfAbsentIn1 = copyOfcharacterFrequencies2.values().stream().mapToInt(Integer::intValue).sum();
        return diff + frequencyOfAbsentIn1;
    }

    private static int pop(Map<Character, Integer> map, Character key, Integer defaultValue) {
        Integer value = map.remove(key);
        return value != null ? value : defaultValue;
    }
}
