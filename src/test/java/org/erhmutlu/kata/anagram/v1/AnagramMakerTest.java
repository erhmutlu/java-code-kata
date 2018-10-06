package org.erhmutlu.kata.anagram.v1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramMakerTest {

    @Test
    public void should_calculate_diff_to_being_anagram() {
        assertThat(AnagramMaker.calculateDiffCount("cde", "ecd")).isEqualTo(0);
        assertThat(AnagramMaker.calculateDiffCount("cde", "abc")).isEqualTo(4);
        assertThat(AnagramMaker.calculateDiffCount("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke")).isEqualTo(30);
        assertThat(AnagramMaker.calculateDiffCount("jxwtrhvujlmrpdoqbisbwhmgpmeoke","fcrxzwscanmligyxyvym")).isEqualTo(30);
    }
}