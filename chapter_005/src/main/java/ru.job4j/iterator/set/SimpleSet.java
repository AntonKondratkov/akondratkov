package ru.job4j.iterator.set;


import ru.job4j.iterator.generic.SimpleArray;

/**
 * Коллекция set на массиве.
 * @param <T> тип данных.
 */
public class SimpleSet<T> extends SimpleArray<T> {
    /**
     * Конструктор
     * @param size длинна массива.
     */
    public SimpleSet(int size) {
        super(size);
    }
    public void add(T model) {
        if (!super.contains(model)) {
            super.add(model);
        }
    }
}
