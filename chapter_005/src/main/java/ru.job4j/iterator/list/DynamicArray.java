package ru.job4j.iterator.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Anton Kondratkov
 * @since 14.08.18.
 * @param <E> Тип хранимых данных.
 */

public class DynamicArray<E> implements Iterable<E> {
    // Хранилище.
    private Object[] container;
    // Размер хранилища.
    private int size = 10;
    // Позиция в массиве.
    private int position = 0;
    // Счётчик изменений коллекции.
    private int modCount = 0;
    /**
     * Конструктор.
     * @param size размер хранилища.
     */
    public DynamicArray(int size) {
        this.size = size;
        this.container = new Object[size];
    }
    /**
     * Метод увеличивает размер массива.
     */
    public void increaseSize() {
        size = size * 2;
    }
    /**
     * Метод добавляет элементы в массив и увеличивает размер массива
     * при необходимости.
     * @param value добавляемый элемент.
     */
    public void add(E value) {
        if (position == size) {
            container = Arrays.copyOf(container, size * 2);
            increaseSize();
            modCount++;
        }
        container[position++] = value;
    }
    /**
     * Метод получает элемент из массива по индексу.
     * @param index индекс элемента.
     * @return полученный по индексу элемент.
     */
    public E get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) container[index];
        }
    }
    /**
     * Итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            // Переменная хранит значение modCount на момент создания.
            final int expectedModCount = modCount;
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                } else if (container[currentIndex] != null && currentIndex < size) {
                    result = true;
                }
                return result;
            }
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[currentIndex++];
            }
        };
    }
}
