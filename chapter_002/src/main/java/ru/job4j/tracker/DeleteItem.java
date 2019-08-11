package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {

    protected DeleteItem(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        output().accept("------------ Удаление заявки --------------");
        String id = input.ask("Введите ID заявки :");
        if (tracker.delete(id)) {
            output().accept("------------ Удалена заявка с getId : " + id + "-----------");
        } else {
            output().accept("------------ Ну удалось удалить заявку с getId : " + id + "-----------");
        }
    }
}