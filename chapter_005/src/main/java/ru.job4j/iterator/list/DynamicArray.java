package ru.job4j.iterator.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Anton Kondratkov
 * @since 13.08.18.
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
    // Переменная хранит значение modCount на момент создания.
    private final int expectedModCount = modCount;
    /**
     * Конструктор.
     * @param size размер хранилища.
     */
    public DynamicArray(int size) {
        this.size = size;
        this.container = new Object[size];
    }
    /**
     * Метод сравнивает значения modCount и expectedModCount.
     */
    final void checkForComodification() {
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
    /**
     * Метод добавляет элементы в массив и увеличивает размер массива
     * при необходимости.
     * @param value добавляемый элемент.
     */
    public void add(E value) {
        if (position == size) {
            container = Arrays.copyOf(container, this.size * 2);
            size = this.size * 2;
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
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (container[currentIndex] != null && currentIndex < size) {
                    result = true;
                }
                return result;
            }
            @Override
            public E next() {
                if (hasNext()) {
                    return (E) container[currentIndex++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
