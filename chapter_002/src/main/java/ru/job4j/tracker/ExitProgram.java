package ru.job4j.tracker;

public class ExitProgram extends BaseAction {

    protected ExitProgram(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        ui.exit();
    }
}