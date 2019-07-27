package ru.job4j.tracker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindItemsByName implements UserAction {

    /**
     * Формат даты создания заявки.
     */
    private final DateFormat df = new SimpleDateFormat("dd:MM:yyyy:HH:mm:");

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = input.ask("Введите имя заявок :");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println("Имя заявки : " + item.getName());
                System.out.println("Описание заявки : " + item.getDecs());
                System.out.println("Дата создания : " + df.format(new Date(item.getTime())));
                System.out.println("------------ Получена информация о заявке с getId : " + item.getId() + "-----------");
            }
        } else {
            System.out.println("------------ Не удалось найти заявок с именем : " + name + "-----------");
        }
    }

    @Override
    public String info() {
        return "Найти заявки по имени.";
    }
}