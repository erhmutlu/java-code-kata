package org.erhmutlu.kata.anagram.v1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramCheckerTest {

    @Test
    public void should_check() {
        assertThat(AnagramChecker.isAnagram("lala", "alal")).isTrue();
        assertThat(AnagramChecker.isAnagram("lala", "alla")).isTrue();
        assertThat(AnagramChecker.isAnagram("anagram", "margana")).isTrue();
        assertThat(AnagramChecker.isAnagram("margana", "anagram")).isTrue();
    }

    @Test
    public void should_not_check() {
        assertThat(AnagramChecker.isAnagram("lalla", "alal")).isFalse();
        assertThat(AnagramChecker.isAnagram("lala", "llll")).isFalse();
        assertThat(AnagramChecker.isAnagram("anagrpm", "margxana")).isFalse();
        assertThat(AnagramChecker.isAnagram("margana", "anagrm")).isFalse();
    }
}