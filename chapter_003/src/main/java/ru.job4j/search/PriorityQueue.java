package ru.job4j.search;

import java.util.LinkedList;
/**
 * @author Anton Kondratkov
 * @since 09.07.18.
 * Данный класс создаёт список задач.
 */

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод вставляет в нужную позицию элемент.
     */
    public void put(Task task) {
        var index = 0;
        Task result = null;
        for (var i = 0; i < this.tasks.size(); i++) {
            if (tasks.get(i).getPriority() <= task.getPriority()) {
                index++;
            } else {
                result = this.tasks.get(i);
                break;
            }
        }

        if (index == tasks.size()) {
            this.tasks.add(index, task);
        } else {
            this.tasks.add(tasks.indexOf(result), task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
