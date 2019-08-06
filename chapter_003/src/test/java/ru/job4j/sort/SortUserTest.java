package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void when3Users() {
        SortUser sort = new SortUser();
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(new User("vasya", 66), new User("petya", 22), new User("vladimir", 20)));
        Set<User> set = sort.sort(list);
        assertThat(set.iterator().next().getName(), is("vladimir"));
    }
}
