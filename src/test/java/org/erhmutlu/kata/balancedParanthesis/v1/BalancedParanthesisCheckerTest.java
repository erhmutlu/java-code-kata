package org.erhmutlu.kata.balancedParanthesis.v1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BalancedParanthesisCheckerTest {

    @Test
    public void should_test() {
        assertThat(BalancedParanthesisChecker.isBalanced("()")).isTrue();
        assertThat(BalancedParanthesisChecker.isBalanced("{}()")).isTrue();
        assertThat(BalancedParanthesisChecker.isBalanced("({()})")).isTrue();
        assertThat(BalancedParanthesisChecker.isBalanced("[]")).isTrue();
        assertThat(BalancedParanthesisChecker.isBalanced("[[][]]")).isTrue();
        assertThat(BalancedParanthesisChecker.isBalanced("(()()()())")).isTrue();
        assertThat(BalancedParanthesisChecker.isBalanced("(()()({})([]))")).isTrue();
        assertThat(BalancedParanthesisChecker.isBalanced("(()((())()))")).isTrue();

        assertThat(BalancedParanthesisChecker.isBalanced("{}(")).isFalse();
        assertThat(BalancedParanthesisChecker.isBalanced("(()()(()")).isFalse();
        assertThat(BalancedParanthesisChecker.isBalanced("({(})")).isFalse();
        assertThat(BalancedParanthesisChecker.isBalanced("[]][[]")).isFalse();
        assertThat(BalancedParanthesisChecker.isBalanced("((((((())")).isFalse();
        assertThat(BalancedParanthesisChecker.isBalanced("][")).isFalse();
    }
}