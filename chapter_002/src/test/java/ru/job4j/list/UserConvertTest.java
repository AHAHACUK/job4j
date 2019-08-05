package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void when4Users() {
        UserConvert converter = new UserConvert();
        List<User> list = new ArrayList<>(Arrays.asList(
                new User(1564, "Ivan", "Moskow"),
                new User(5177, "Evgeniy", "Perm")
        ));
        HashMap<Integer, User> out = converter.process(list);
        assertThat(out.get(5177).getName(), is("Evgeniy"));
    }
}
