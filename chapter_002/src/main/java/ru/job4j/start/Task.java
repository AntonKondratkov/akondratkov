package ru.job4j.start;

import ru.job4j.tracker.Item;

public class Task extends Item {
    public Task(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public String calculatePrice() {
        return "100%";
    }

    @Override
    public String toString() {
        return "Имя: " + this.name + ", " + "description:" + this.description;
    }
}

