package ru.job4j.search;

import java.util.LinkedList;
/**
 * @author Anton Kondratkov
 * @since 22.07.18.
 * Данный класс создаёт список задач.
 */

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод вставляет в нужную позицию элемент.
     */
    public void put(Task task) {
        tasks.add(task.getPriority(), task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
