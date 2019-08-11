package ru.job4j.tracker;

import java.util.function.Consumer;

public class AddItem extends BaseAction {

    protected AddItem(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        output().accept("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        output().accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
}