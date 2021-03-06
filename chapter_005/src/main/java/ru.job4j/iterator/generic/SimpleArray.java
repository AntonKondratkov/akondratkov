package ru.job4j.iterator.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Anton Kondratkov
 * @since 29.08.2018
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
    public void add(T model) {
        arrayOut(this.index);
            this.objects[this.index++] = model;
    }
    /**
     * Метод добавляет новое значение по индексу.
     * @param index позиция в массиве.
     * @param model новое значение.
     */
    public void set(int index, T model) {
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
        if (this.objects.length == index + 1) {
            this.objects[this.objects.length - 1] = null;
        }
        if (index < this.objects.length) {
            System.arraycopy(this.objects, index + 1, this.objects, index, this.index - index - 1);
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
        return (T) objects[index];
    }

    public int getSize() {
        return this.objects.length;
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

    /**
     * Метод проверяет содержится ли элемент в массиве.
     * @param value проверяемый элемент.
     * @return true - если содержится, false - если не содержится.
     */
    public boolean contains(T value) {
        boolean found = false;
        if (this.objects != null) {
            for (int i = 0; i < getSize(); i++) {
                if (this.objects[i] != null) {
                    if (this.objects[i].equals(value)) {
                        found = true;
                        break;
                    }
                }
            }
        }
        return found;
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
                return (T) objects[inIterator++];
            }
        };
    }
}
