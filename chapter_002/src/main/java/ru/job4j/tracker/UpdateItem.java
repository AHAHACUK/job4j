package ru.job4j.tracker;

import java.util.function.Consumer;

public class UpdateItem extends BaseAction {

    protected UpdateItem(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        output().accept("------------ Редактирование заявки --------------");
        String id = input.ask("Введите ID заявки :");
        String name = input.ask("Введите новое название заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (tracker.replace(id, item)) {
            output().accept("------------ Изменена заявка с getId : " + item.getId() + "-----------");
        } else {
            output().accept("------------ Не удалось изменить заявку с getId : " + item.getId() + "-----------");
        }
    }
}