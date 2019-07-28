package ru.job4j.tracker;

public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker, StartUI ui);

    String info();
}