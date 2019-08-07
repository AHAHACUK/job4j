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
        Item item1 = new Item("test1", "testDesc", 123L);
        Item item2 = new Item("test2", "testDesc", 1234L);
        Item item3 = new Item("test3", "testDesc", 1232L);
        Item item4 = new Item("test4", "testDesc", 1231L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        assertThat(tracker.findAll().get(3).getName(), is("test4"));
    }

    @Test
    public void whenFindByName1Element() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDesc", 123L);
        tracker.add(item);
        assertThat(tracker.findByName("test1").get(0).getName(), is("test1"));
    }

    @Test
    public void whenFindByName2Elements() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDesc", 123L);
        Item item2 = new Item("test1", "testDesc1", 1232L);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findByName("test1").get(0).getDecs(), is("testDesc"));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDesc", 123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
}