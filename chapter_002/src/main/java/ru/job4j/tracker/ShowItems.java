package ru.job4j.tracker;

public class ShowItems implements UserAction {

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        System.out.println("------------ Список заявок --------------");
        for (Item i : tracker.findAll()) {
            System.out.println("[" + i.getId() + "] " + i.getName());
        }
        System.out.println("-----------------------");
    }

    @Override
    public String info() {
        return "Показать все заяки.";
    }
}