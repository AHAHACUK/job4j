package ru.job4j.tracker;

public class ExitProgram implements UserAction {

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        ui.exit();
    }

    @Override
    public String info() {
        return "Выйти.";
    }
}