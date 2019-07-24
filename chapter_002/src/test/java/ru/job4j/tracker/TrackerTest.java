package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDesc", 123L);
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item[] expected = new Item[4];
        Item item1 = new Item("test1", "testDesc", 123L);
        Item item2 = new Item("test2", "testDesc", 1234L);
        Item item3 = new Item("test3", "testDesc", 1232L);
        Item item4 = new Item("test4", "testDesc", 1231L);
        expected[0] = item1;
        expected[1] = item2;
        expected[2] = item3;
        expected[3] = item4;
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenFindByName1Element() {
        Tracker tracker = new Tracker();
        Item[] expected = new Item[1];
        Item item = new Item("test1", "testDesc", 123L);
        expected[0] = item;
        tracker.add(item);
        assertThat(tracker.findByName("test1"), is(expected));
    }

    @Test
    public void whenFindByName2Elements() {
        Tracker tracker = new Tracker();
        Item[] expected = new Item[2];
        Item item1 = new Item("test1", "testDesc", 123L);
        Item item2 = new Item("test1", "testDesc1", 1232L);
        expected[0] = item1;
        expected[1] = item2;
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findByName("test1"), is(expected));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDesc", 123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
}