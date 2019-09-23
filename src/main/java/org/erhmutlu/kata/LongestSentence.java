package org.erhmutlu.kata;

import java.util.Arrays;
import java.util.Comparator;

// Q1: RETURN COUNT OF WORDS OF LONGEST SENTENCE IN THE TEXT
public class LongestSentence {

    private static final String SENTENCE_DELIMITER = "\\.|\\?|\\!";
    private static final String WORD_DELIMITER = " ";

    public int solution(String S) {
        String[] sentences = S.split(SENTENCE_DELIMITER);
        long maxLength = Arrays.stream(sentences)
                .map(sentence -> sentence.split(WORD_DELIMITER))
                .map(this::getWordCount)
                .max(Comparator.naturalOrder())
                .orElse(0l);

        return Math.toIntExact(maxLength);
    }

    private long getWordCount(String[] words) {
        return Arrays.stream(words)
                .map(word -> word.replaceAll(" ", ""))
                .filter(word -> !word.equals(""))
                .count();
    }


}
