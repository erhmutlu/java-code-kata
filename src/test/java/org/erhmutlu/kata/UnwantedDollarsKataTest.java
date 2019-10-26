package org.erhmutlu.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnwantedDollarsKataTest {

    @Test
    public void should_convert_to_money_value() {
        assertEquals(12.34, UnwantedDollarsKata.moneyValue("12.34"), 1e-9);
        assertEquals(5.67, UnwantedDollarsKata.moneyValue(" $5.67"), 1e-9);
        assertEquals(-0.89, UnwantedDollarsKata.moneyValue("-0.89"), 1e-9);
        assertEquals(-0.10, UnwantedDollarsKata.moneyValue("-$ 0.1"), 1e-9);
        assertEquals(-2.3456, UnwantedDollarsKata.moneyValue("$-2.3456"), 1e-9);
        assertEquals(7, UnwantedDollarsKata.moneyValue("007"), 1e-9);
        assertEquals(89.0, UnwantedDollarsKata.moneyValue(" $ 89"), 1e-9);
        assertEquals(0.11, UnwantedDollarsKata.moneyValue("   .11"), 1e-9);
        assertEquals(0.20, UnwantedDollarsKata.moneyValue("$.2"), 1e-9);
        assertEquals(-0.34, UnwantedDollarsKata.moneyValue("-.34"), 1e-9);
        assertEquals(0.0, UnwantedDollarsKata.moneyValue("$$$"), 1e-9);
    }
}