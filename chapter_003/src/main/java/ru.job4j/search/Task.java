package ru.job4j.search;
/**
 * @author Anton Kondratkov
 * @since 22.07.18.
 * В данном классе создаём объект "Задача" с полями: desc, priority.
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return getPriority() + " " + getDesc();
    }
}
