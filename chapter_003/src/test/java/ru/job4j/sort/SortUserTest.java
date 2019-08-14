package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void when3Users() {
        SortUser sort = new SortUser();
        List<User> list = List.of(new User("vasya", 66), new User("petya", 22), new User("vladimir", 20));
        Set<User> set = sort.sort(list);
        assertThat(set.iterator().next().getName(), is("vladimir"));
    }

    @Test
    public void whenSortByNameLength() {
        SortUser sort = new SortUser();
        List<User> list = List.of(new User("vladimir", 66), new User("evgeniy", 22), new User("petya", 20));
        List<User> set = sort.sortNameLength(list);
        assertThat(set.iterator().next().getName(), is("petya"));
    }

    @Test
    public void whenSortBAllFields() {
        SortUser sort = new SortUser();
        List<User> list = List.of(new User("Сергей", 25), new User("Иван", 30), new User("Сергей", 20), new User("Иван", 25));
        List<User> set = sort.sortByAllFields(list);
        assertThat(set.iterator().next().getName(), is("Иван"));
    }
}
