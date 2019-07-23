package ru.job4j.proffesions;

import java.util.Date;

public class Programmer extends Engineer {

    public Programmer(String name, String surname, String education, Date birthday, int salary) {
        super(name, surname, education, birthday, salary);
    }

    public Code write() {
        return null;
    }
}
