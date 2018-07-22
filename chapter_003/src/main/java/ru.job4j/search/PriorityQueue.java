package ru.job4j.search;

import java.util.LinkedList;
/**
 * @author Anton Kondratkov
 * @since 23.07.18.
 * Данный класс создаёт список задач.
 */

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод вставляет в нужную позицию элемент.
     */
    public void put(Task task) {
        tasks.add(task);
    }

    public Task take() {
        Task result = this.tasks.get(0);
        for (Task value : this.tasks) {
            if (result.getPriority() > value.getPriority()) {
                this.tasks.addFirst(value);
            }
        }
        return this.tasks.poll();
    }
}
