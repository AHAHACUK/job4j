package ru.job4j.tracker;


import java.util.ArrayList;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * Пользовательский интерфейс.
     */
    private StartUI ui;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private ArrayList<UserAction> actions = new ArrayList<UserAction>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, StartUI ui) {
        this.input = input;
        this.tracker = tracker;
        this.ui = ui;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new UpdateItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new ExitProgram());
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker, this.ui);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (int i = 0; i < getActionsLentgh(); i++) {
            if (actions.get(i) != null) {
                System.out.println(i + ". " + actions.get(i).info());
            }
        }
    }
}