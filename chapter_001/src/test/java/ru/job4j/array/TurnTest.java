package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void when5elements() {
        Turn turn = new Turn();
        int[] in = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        int[] out = turn.back(in);
        assertThat(expected, is(expected));
    }

    @Test
    public void when4elements() {
        Turn turn = new Turn();
        int[] in = {1, 2, 3, 4};
        int[] expected = {4, 3, 2, 1};
        int[] out = turn.back(in);
        assertThat(expected, is(expected));
    }
}
