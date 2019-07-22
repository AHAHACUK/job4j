package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortTest {

    @Test
    public void when2() {
        Sort sort = new Sort();
        int[] inA = {1,3};
        int[] inB = {2,4};
        int[] expected = {1,2,3,4};
        int[] out = sort.merge(inA, inB);
        assertThat(out, is(expected));
    }

    @Test
    public void when5() {
        Sort sort = new Sort();
        int[] inA = {1,3,6,10,15};
        int[] inB = {2,4,7,8,11};
        int[] expected = {1,2,3,4,6,7,8,10,11,15};
        int[] out = sort.merge(inA, inB);
        assertThat(out, is(expected));
    }

    @Test
    public void when3and5() {
        Sort sort = new Sort();
        int[] inA = {1,8,9};
        int[] inB = {2,7,10,11,12};
        int[] expected = {1,2,7,8,9,10,11,12};
        int[] out = sort.merge(inA, inB);
        assertThat(out, is(expected));
    }
}
