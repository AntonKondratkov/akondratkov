package ru.job4j.tracker.model;

import java.util.Objects;

/**
 * @version $Id$
 * @since 0.inheritance
 * В данном  классе описывается заявка (поля класса, конструкторы, сеттеры и геттеры).
 * Объекты данного класса используются в работе класса Tracker.
 */

public class Item {
    private String id;
    public String name;
    public String description;
    public long create;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }
    public Item(String name, String description, String id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }


    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Имя заявки: " + name + ", " + "Описание заявки: " + description + " id заявки: " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name)
                && Objects.equals(description, item.description)
                && Objects.equals(id, item.id);
    }
    @Override
    public int hashCode() {
        return 0;
    }
}

