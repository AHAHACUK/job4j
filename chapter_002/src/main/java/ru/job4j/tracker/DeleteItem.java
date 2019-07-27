package ru.job4j.tracker;

public class DeleteItem implements UserAction {

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

    @Override
    public String info() {
        return "Удалить заявку.";
    }
}