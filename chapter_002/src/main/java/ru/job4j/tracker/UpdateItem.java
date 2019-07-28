package ru.job4j.tracker;

public class UpdateItem extends BaseAction {

    protected UpdateItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите ID заявки :");
        String name = input.ask("Введите новое название заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (tracker.replace(id, item)) {
            System.out.println("------------ Изменена заявка с getId : " + item.getId() + "-----------");
        } else {
            System.out.println("------------ Не удалось изменить заявку с getId : " + item.getId() + "-----------");
        }
    }
}