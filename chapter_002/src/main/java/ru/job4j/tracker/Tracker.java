package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    public boolean replace(String id, Item item) {
        int index = getIndex(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
        items.set(index, item);
        return true;
    }

    public boolean delete(String id) {
        int index = getIndex(id);
        if (index == -1) {
            return false;
        }
        items.remove(index);
        return true;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    private int getIndex(Item item) {
        int result = -1;
        for (int i = 0; i < position; i++) {
            if (items.get(i) != null && item.equals((items.get(i)))) {
                result = i;
                break;
            }
        }
        return result;
    }

    private int getIndex(String id) {
        int result = -1;
        for (int i = 0; i < position; i++) {
            if (items.get(i) != null && id.equals(items.get(i).getId())) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        String generatedId = Long.toString(System.currentTimeMillis()) + "" + (Math.round(Math.random() * 100));
        return generatedId;
    }
}