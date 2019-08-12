package ru.job4j.tracker;

import java.util.function.Consumer;

public class ShowItems extends BaseAction {

    protected ShowItems(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        output().accept("------------ Список заявок --------------");
        for (Item i : tracker.findAll()) {
            output().accept("[" + i.getId() + "] " + i.getName());
        }
        output().accept("-----------------------");
    }
}