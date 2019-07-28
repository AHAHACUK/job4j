package ru.job4j.tracker;

public class ShowItems extends BaseAction {

    protected ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, StartUI ui) {
        System.out.println("------------ Список заявок --------------");
        for (Item i : tracker.findAll()) {
            System.out.println("[" + i.getId() + "] " + i.getName());
        }
        System.out.println("-----------------------");
    }
}