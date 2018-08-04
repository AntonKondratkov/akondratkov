package ru.job4j.iterator.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Anton Kondratkov
 * @since 04.08.2018
 * Класс SimpleArray - универсальная обёртка над массивом.
 * @param <T> Параметризированный тип.
 */

public class SimpleArray<T> implements Iterable<T> {
    /**
     * Позиция в массиве.
     */
    private int index = 0;
    /**
     * Массив.
     */
    private Object[] objects;
    /**
     * Конструктор
     * @param size длинна массива.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }
    /**
     * Метод добавляет новые элементы в массив.
     * @param model новый элемент.
     */
    public void add (T model) {
        arrayOut(index);
            this.objects[index++] = model;
    }
    /**
     * Метод добавляет новое значение по индексу.
     * @param index позиция в массиве.
     * @param model новое значение.
     */
    public void set (int index, T model) {
        arrayOut(index);
        this.objects[index] = model;
    }
    /**
     * Метод удаляет значение по индексу.
     * @param index позиция в массиве.
     * @return true - позиция удалёна, false -  позиция не удалёна.
     */
    public boolean delete(int index) {
        boolean result = false;
        if (index < this.index) {
            objects[index] = objects[this.index - 1];
            objects[this.index - 1] = null;
            result = true;
        }
        return result;
    }
    /**
     * Метод получает значение по индексу.
     * @param index позиция в массиве.
     * @return найденная позиция.
     */
    public T get(int index) {
        arrayOut(index);
        return (T)objects[index];
    }

    /**
     * Метод определяет выход за пределы массива.
     * @param index позиция в массиве.
     */

    public void arrayOut(int index) {
        if (index >= objects.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
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
                    throw new NoSuchElementException();
                }
                return (T)objects[inIterator++];
            }
        };
    }
}
