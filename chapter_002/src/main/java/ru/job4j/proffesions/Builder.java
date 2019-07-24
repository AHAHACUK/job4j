package ru.job4j.proffesions;

import java.util.Date;

public class Builder extends Engineer {

    public Builder(String name, String surname, String education, Date birthday, int salary) {
        super(name, surname, education, birthday, salary);
    }

    public void work(Plan play) {}

}
