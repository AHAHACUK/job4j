package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerSingleTest {

    @Test
    public void whenTracker1() {
        TrackerSingle1 tracker1 = TrackerSingle1.INSTANCE;
        TrackerSingle1 tracker2 = TrackerSingle1.INSTANCE;
        assertThat(tracker1 == tracker2, is(true));
    }

    @Test
    public void whenTracker2() {
        TrackerSingle2 tracker1 = TrackerSingle2.getInstance();
        TrackerSingle2 tracker2 = TrackerSingle2.getInstance();
        assertThat(tracker1 == tracker2, is(true));
    }

    @Test
    public void whenTracker3() {
        TrackerSingle3 tracker1 = TrackerSingle3.getInstance();
        TrackerSingle3 tracker2 = TrackerSingle3.getInstance();
        assertThat(tracker1 == tracker2, is(true));
    }

    @Test
    public void whenTracker4() {
        TrackerSingle4 tracker1 = TrackerSingle4.getInstance();
        TrackerSingle4 tracker2 = TrackerSingle4.getInstance();
        assertThat(tracker1 == tracker2, is(true));
    }
}
