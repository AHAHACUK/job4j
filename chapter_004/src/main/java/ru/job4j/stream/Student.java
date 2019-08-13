package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student{
    private String surname;
    private int score;

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return Integer.compare(o1.getScore(), o2.getScore());
                    }
                }
        ).flatMap(Stream::ofNullable).takeWhile(e -> e.getScore() > bound).collect(Collectors.toList());
    }
}
