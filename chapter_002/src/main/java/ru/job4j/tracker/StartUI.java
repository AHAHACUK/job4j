package ru.job4j.tracker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String SHOW = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по ID.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа меню для поиска заявок по названию.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Формат даты создания заявки.
     */
    private final DateFormat df = new SimpleDateFormat("dd:MM:yyyy:HH:mm:");
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод выводит в консоль список всех заявок.
     */
    private void showItems() {

        System.out.println("------------ Список заявок --------------");
        for (Item i : this.tracker.findAll()) {
            System.out.println("[" + i.getId() + "] " + i.getName());
        }
        System.out.println("-----------------------");
    }

    /**
     * Метод редактируют заявку.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите ID заявки :");
        String name = this.input.ask("Введите новое название заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.replace(id, item);
        System.out.println("------------ Изменена заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод удаляет заявку из хранилища.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки :");
        this.tracker.delete(id);
        System.out.println("------------ Удалена заявка с getId : " + id + "-----------");
    }

    /**
     * Метод выводит информацию о заявке, найденной по ID, в консоль.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки :");
        Item item = this.tracker.findById(id);
        System.out.println("Имя заявки : " + item.getName());
        System.out.println("Описание заявки : " + item.getDecs());
        System.out.println("Дата создания : " + df.format(new Date(item.getTime())));
        System.out.println("------------ Получена информация о заявке с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод выводит информацию о заявке, найденной по имени, в консоль.
     */
    private void findItemByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявок :");
        Item[] items = this.tracker.findByName(name);
        for (Item item : items) {
            System.out.println("Имя заявки : " + item.getName());
            System.out.println("Описание заявки : " + item.getDecs());
            System.out.println("Дата создания : " + df.format(new Date(item.getTime())));
            System.out.println("------------ Получена информация о заявке с getId : " + item.getId() + "-----------");
        }
    }

    /**
     * Метод выводит в консоль список доступных команд.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}