package ru.job4j.proffesions;

import java.util.Date;

public class Engineer extends Profession {

    public Engineer(String name, String surname, String education, Date birthday, int salary) {
        super(name, surname, education, birthday, salary);
    }

    public Plan plan() {
        return null;
    }
}
