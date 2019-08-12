package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.function.Consumer;

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
    private ArrayList<UserAction> actions = new ArrayList<>();

    private final Consumer<String> output;

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, StartUI ui, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.ui = ui;
        this.output = output;
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
        this.actions.add(new AddItem(0, "Добавить заявку.", this.output));
        this.actions.add(new ShowItems(1, "Показать все заявки.", this.output));
        this.actions.add(new UpdateItem(2, "Редактировать заявку.", this.output));
        this.actions.add(new DeleteItem(3, "Удалить заявку.", this.output));
        this.actions.add(new FindItemById(4, "Найти заявку по ID", this.output));
        this.actions.add(new FindItemsByName(5, "Найти заявки по имени.", this.output));
        this.actions.add(new ExitProgram(6, "Выход.", this.output));
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
        for (UserAction action : actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }
}