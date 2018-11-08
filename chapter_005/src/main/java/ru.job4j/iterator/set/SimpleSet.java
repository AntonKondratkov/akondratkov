package ru.job4j.iterator.set;


import ru.job4j.iterator.generic.SimpleArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Коллекция set на массиве.
 * @param <T> тип данных.
 */
public class SimpleSet<T> implements Iterable<T> {
    /**
     * Позиция в массиве.
     */
    private int index = 0;
    /**
     * Объект класса SimpleArray.
     */
    private SimpleArray<T> array = new SimpleArray<>(2);
    /**
     * Метод добавляет новые элементы.
     * @param model добавляемый элемент.
     */
    public void add(T model) {
        if (!array.contains(model)) {
            array.add(model);
            index++;
        }
    }
    /**
     * Метод получает значение по индексу.
     * @param index позиция в массиве.
     * @return найденная позиция.
     */
    public T get(int index) {
        return array.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int inIterator = 0;
            @Override
            public boolean hasNext() {
                boolean indicator = true;
                if (inIterator >= index) {
                    indicator = false;
                }
                return indicator;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Элементы не найдены");
                }
                return array.get(inIterator++);
            }
        };
    }
}
