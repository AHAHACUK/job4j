package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

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
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        int index = getIndex(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
        items[index] = item;
        return true;
    }

    public boolean delete(String id) {
        int index = getIndex(id);
        if (index == -1) {
            return false;
        }
        System.arraycopy(items, index + 1, items, index, 99 - index);
        position--;
        items[99] = null;
        return true;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[100];
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                result[count++] = items[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    private int getIndex(Item item) {
        int result = -1;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && item.equals(items[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    private int getIndex(String id) {
        int result = -1;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && id.equals(items[i].getId())) {
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