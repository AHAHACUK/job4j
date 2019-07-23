package ru.job4j.proffesions;

import java.util.Date;

public class Profession {

    private String name;
    private String surname;
    private String education;
    private Date birthday;
    private int salary;

    public Profession(String name, String surname, String education, Date birthday, int salary) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return surname + " " + name;
    }

    public String getEducation() {
        return education;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getSalary() {
        return salary;
    }
}
