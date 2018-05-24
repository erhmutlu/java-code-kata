package org.erhmutlu.kata.accessPrivate.v1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PowerOfTwoCheckerTest {

    @Test
    public void should_check() throws Exception {
        assertThat(PowerOfTwoChecker.checkPowerOf2(1)).isTrue();
        assertThat(PowerOfTwoChecker.checkPowerOf2(8)).isTrue();
        assertThat(PowerOfTwoChecker.checkPowerOf2(16)).isTrue();
        assertThat(PowerOfTwoChecker.checkPowerOf2(32)).isTrue();
        assertThat(PowerOfTwoChecker.checkPowerOf2(512)).isTrue();
    }

    @Test
    public void should_not_check() throws Exception {
        assertThat(PowerOfTwoChecker.checkPowerOf2(17)).isFalse();
        assertThat(PowerOfTwoChecker.checkPowerOf2(23)).isFalse();
        assertThat(PowerOfTwoChecker.checkPowerOf2(101)).isFalse();
        assertThat(PowerOfTwoChecker.checkPowerOf2(1000)).isFalse();
    }
}