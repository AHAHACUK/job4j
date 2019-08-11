package ru.job4j.tracker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public class FindItemsByName extends BaseAction {

    private final DateFormat df = new SimpleDateFormat("dd:MM:yyyy:HH:mm:");

    protected FindItemsByName(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        output().accept("------------ Поиск заявки по имени --------------");
        String name = input.ask("Введите имя заявок :");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                output().accept("Имя заявки : " + item.getName());
                output().accept("Описание заявки : " + item.getDecs());
                output().accept("Дата создания : " + df.format(new Date(item.getTime())));
                output().accept("------------ Получена информация о заявке с getId : " + item.getId() + "-----------");
            }
        } else {
            output().accept("------------ Не удалось найти заявок с именем : " + name + "-----------");
        }
    }
}