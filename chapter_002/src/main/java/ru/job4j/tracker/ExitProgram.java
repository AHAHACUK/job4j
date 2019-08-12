package ru.job4j.tracker;

import java.util.function.Consumer;

public class ExitProgram extends BaseAction {

    protected ExitProgram(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        ui.exit();
    }
}