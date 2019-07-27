package ru.job4j.tracker;

public class AddItem implements UserAction {

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    @Override
    public String info() {
        return "Добавить новую заявку.";
    }
}