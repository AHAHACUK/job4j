package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void max() {
        int out = SqMax.max(2,2,20,2);
        assertThat(out, is(20));
    }
}
