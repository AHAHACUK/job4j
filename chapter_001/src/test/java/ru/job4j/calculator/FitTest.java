package ru.job4j.calculator;

import org.junit.Test;

public class FitTest {
    @Test
    public void manWeight() {
        double in = 160;
        double expected = 69;
        double out = Fit.manWeight(in);

    }

    @Test
    public void womanWeight() {
        double in = 160;
        double expected = 57.5;
        double out = Fit.womanWeight(in);
    }
}
