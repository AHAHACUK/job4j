package ru.job4j.diaposon;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CalculateTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calculate function = new Calculate();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQudraticFunctionThenQudraticResults() {
        Calculate function = new Calculate();
        List<Double> result = function.diapason(2, 5, x -> x * x + 6);
        List<Double> expected = Arrays.asList(10D, 15D, 22D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Calculate function = new Calculate();
        List<Double> result = function.diapason(10, 11, x -> Math.log10(x));
        List<Double> expected = Arrays.asList(1D);
        assertThat(result, is(expected));
    }
}
