package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    @Test
    public void whenAClass() {
        School school = new School();
        List<Student> students = new ArrayList<>(
                Arrays.asList(new Student(20), new Student(60), new Student(90))
        );
        List<Student> out = school.collect(students, student -> student.getScore() >= 70);
        assertThat(out.get(0).getScore(), is(90));
    }

    @Test
    public void whenBClass() {
        School school = new School();
        List<Student> students = new ArrayList<>(
                Arrays.asList(new Student(20), new Student(60), new Student(90))
        );
        List<Student> out = school.collect(students, student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(out.get(0).getScore(), is(60));
    }

    @Test
    public void whenCClass() {
        School school = new School();
        List<Student> students = new ArrayList<>(
                Arrays.asList(new Student(20), new Student(60), new Student(90))
        );
        List<Student> out = school.collect(students, student -> student.getScore() < 50);
        assertThat(out.get(0).getScore(), is(20));
    }
}
