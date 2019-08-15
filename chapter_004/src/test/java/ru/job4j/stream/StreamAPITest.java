package ru.job4j.stream;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreamAPITest {
    @Test
    public void when3Numbers() {
        StreamAPI streamAPI = new StreamAPI();
        int[] in = new int[] {0, 1, 2, 3, 4};
        int expected = 20;
        int out = streamAPI.calculate(in);
        assertThat(out, is(expected));
    }

    @Test
    public void when0Numbers() {
        StreamAPI streamAPI = new StreamAPI();
        int[] in = new int[] {1, 3, 5, 7};
        int expected = 0;
        int out = streamAPI.calculate(in);
        assertThat(out, is(expected));
    }
}
