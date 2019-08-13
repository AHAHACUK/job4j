package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void when9ToList() {
        Matrix matrix = new Matrix();
        Integer[][] in = new Integer[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> out = matrix.matrixToList(in);
        assertThat(out.get(6), is(7));
    }
}
