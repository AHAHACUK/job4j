package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
    @Test
    public void when50Value35PriceThen10and5() {
        CoffeeMachine cm = new CoffeeMachine();
        int value = 50;
        int price = 35;
        int[] expected = {10, 5};
        int[] out = cm.change(value, price);
        assertThat(out, is(expected));
    }

    @Test
    public void when50Value32Price() {
        CoffeeMachine cm = new CoffeeMachine();
        int value = 50;
        int price = 32;
        int[] expected = {10, 5, 2, 1};
        int[] out = cm.change(value, price);
        assertThat(out, is(expected));
    }
}
