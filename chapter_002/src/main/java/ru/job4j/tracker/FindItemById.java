package ru.job4j.tracker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindItemById implements UserAction {

    private final DateFormat df = new SimpleDateFormat("dd:MM:yyyy:HH:mm:");

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = input.ask("Введите ID заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Имя заявки : " + item.getName());
            System.out.println("Описание заявки : " + item.getDecs());
            System.out.println("Дата создания : " + df.format(new Date(item.getTime())));
            System.out.println("------------ Получена информация о заявке с getId : " + item.getId() + "-----------");
        } else {
            System.out.println("------------ Не удалось найти заявку с getId : " + item.getId() + "-----------");
        }
    }

    @Override
    public String info() {
        return "Найти заявку по ID.";
    }
}