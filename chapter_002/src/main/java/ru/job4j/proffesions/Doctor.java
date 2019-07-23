package ru.job4j.proffesions;

import java.util.Date;

public class Doctor extends Profession {

    public Doctor(String name, String surname, String education, Date birthday, int salary) {
        super(name, surname, education, birthday, salary);
    }

    public void cure(Patient pacient) {

    }
}
