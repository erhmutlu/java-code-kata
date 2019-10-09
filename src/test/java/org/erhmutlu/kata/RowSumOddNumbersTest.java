package org.erhmutlu.kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowSumOddNumbersTest {

    @Test
    public void should_sum() {
        //when & then
        assertThat(RowSumOddNumbers.sumOfOddNumbersRow(1)).isEqualTo(1);
        assertThat(RowSumOddNumbers.sumOfOddNumbersRow(2)).isEqualTo(8);
        assertThat(RowSumOddNumbers.sumOfOddNumbersRow(3)).isEqualTo(27);
        assertThat(RowSumOddNumbers.sumOfOddNumbersRow(4)).isEqualTo(64);
    }
}