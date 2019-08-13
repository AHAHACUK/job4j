package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        var isLowerPriority = true;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getPriority() >= task.getPriority()) {
                tasks.add(i, task);
                isLowerPriority = false;
                break;
            }
        }
        if (isLowerPriority) {
            tasks.addLast(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}