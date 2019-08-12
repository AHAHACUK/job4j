package ru.job4j.tracker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

public class FindItemById extends BaseAction {

    private final DateFormat df = new SimpleDateFormat("dd:MM:yyyy:HH:mm:");

    protected FindItemById(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        output().accept("------------ Поиск заявки по ID --------------");
        String id = input.ask("Введите ID заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            output().accept("Имя заявки : " + item.getName());
            output().accept("Описание заявки : " + item.getDecs());
            output().accept("Дата создания : " + df.format(new Date(item.getTime())));
            output().accept("------------ Получена информация о заявке с getId : " + item.getId() + "-----------");
        } else {
            output().accept("------------ Не удалось найти заявку с getId : " + item.getId() + "-----------");
        }
    }
}