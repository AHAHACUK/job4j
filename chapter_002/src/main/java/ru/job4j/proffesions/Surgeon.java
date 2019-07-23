package ru.job4j.proffesions;

import java.util.Date;

public class Surgeon extends Doctor {

    public Surgeon(String name, String surname, String education, Date birthday, int salary) {
        super(name, surname, education, birthday, salary);
    }

    public void operation(Patient pacient) {

    }
}
