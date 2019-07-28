package ru.job4j.tracker;

public class DeleteItem extends BaseAction {

    protected DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        System.out.println("------------ Удаление заявки --------------");
        String id = input.ask("Введите ID заявки :");
        if (tracker.delete(id)) {
            System.out.println("------------ Удалена заявка с getId : " + id + "-----------");
        } else {
            System.out.println("------------ Ну удалось удалить заявку с getId : " + id + "-----------");
        }
    }
}