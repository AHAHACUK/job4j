package ru.job4j.search;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFind2ByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Vladimir", "Dobrov", "534887", "Omsk")
        );
        List<Person> persons = phones.find("534");
        Iterator<Person> iterator = persons.iterator();
        assertThat(iterator.next().getSurname(), is("Arsentev"));
        assertThat(iterator.next().getSurname(), is("Dobrov"));
    }
}