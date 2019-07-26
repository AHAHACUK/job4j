package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final String nl = System.lineSeparator();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final DateFormat df = new SimpleDateFormat("dd:MM:yyyy:HH:mm:");

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    private String menu() {
        return new StringBuilder()
                .append("Меню." + nl)
                .append("0. Add new Item" + nl)
                .append("1. Show all items" + nl)
                .append("2. Edit item" + nl)
                .append("3. Delete item" + nl)
                .append("4. Find item by Id" + nl)
                .append("5. Find items by name" + nl)
                .append("6. Exit Program" + nl)
                .toString();
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasNoItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindByID() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu())
                                .append("------------ Поиск заявки по ID --------------" + nl)
                                .append("Имя заявки : " + item.getName() + nl)
                                .append("Описание заявки : " + item.getDecs() + nl)
                                .append("Дата создания : " + df.format(new Date(item.getTime())) + nl)
                                .append("------------ Получена информация о заявке с getId : " + item.getId() + "-----------" + nl)
                                .append(menu())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu())
                                .append("------------ Поиск заявки по имени --------------" + nl)
                                .append("Имя заявки : " + item.getName() + nl)
                                .append("Описание заявки : " + item.getDecs() + nl)
                                .append("Дата создания : " + df.format(new Date(item.getTime())) + nl)
                                .append("------------ Получена информация о заявке с getId : " + item.getId() + "-----------" + nl)
                                .append(menu())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test2 name", "desc2", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu())
                                .append("------------ Список заявок --------------" + nl)
                                .append("[" + item1.getId() + "] " + item1.getName() + nl)
                                .append("[" + item2.getId() + "] " + item2.getName() + nl)
                                .append("-----------------------" + nl)
                                .append(menu())
                                .toString()
                )
        );
    }
}
