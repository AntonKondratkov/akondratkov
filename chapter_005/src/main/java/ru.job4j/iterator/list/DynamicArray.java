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
    private E[] container;
    // Размер хранилища.
    private int size;
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
        this.container = (E[]) new Object[size];
    }
    /**
     * Конструктор.
     * @param container массив.
     * @param size размер массива.
     */
    public DynamicArray(E[] container, int size) {
        this.size = size;
        this.container = container;
    }
    /**
     * Метод увеличивает размер массива.
     */
    public int increaseSize() {
        return size *= 2;
    }
    /**
     * Метод добавляет элементы в массив и увеличивает размер массива
     * при необходимости.
     * @param value добавляемый элемент.
     */
    public void add(E value) {
        if (position == size) {
            container = Arrays.copyOf(container, increaseSize());
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
     * Метод возвращает размер массива.
     * @return size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Метод копирует массив.
     * @return копия массива.
     */
    public DynamicArray<E> copy() {
        return new DynamicArray<>(this.container.clone(), this.size);
    }

    public int getModCount() {
        return modCount;
    }
    /**
     * Итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;
            int expectedModCount = getModCount();
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }
            @Override
            public E next() {
                if (expectedModCount != getModCount()) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[currentIndex++];
            }
        };
    }
}
