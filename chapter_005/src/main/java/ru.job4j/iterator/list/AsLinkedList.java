package ru.job4j.iterator.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Anton Kondratkov
 * @since 25.08.18.
 * Связный список.
 **/
public class AsLinkedList<e> implements Iterable<e> {
    // Размер списка.
    private int size;
    // Первый элемент.
    private Node<e> first;
    // Последний элемент.
    private Node<e> last;
    // Счётчик изменений коллекции.
    private int modCount = 0;
    /**
     * Конструктор
     */
    public AsLinkedList() {
        this.size = 0;
    }
    /**
     * Добавление элементов в конец списка.
     * @param data добавляемый элемент.
     */
    public void addLast(e data) {
        final Node<e> result = last;
        final Node<e> newLink = new Node<>(result, data, null);
        last = newLink;
        if (result == null) {
            first = newLink;
        } else {
            result.next = newLink;
        }
        size++;
        modCount++;
    }

    /**
     * Добавление элементов в начало списка.
     * @param data добавляемый элемент.
     */
    public void addFirst(e data) {
        final Node<e> result = first;
        final Node<e> newLink = new Node<>(null, data, result);
        first = newLink;
        if (result == null) {
            last = newLink;
        } else {
            result.prev = newLink;
        }
        size++;
        modCount++;
    }
    /**
     * Получение элемента по индексу.
     * @param index индекс.
     * @return элемент
     */
    public e get(int index) {

        if (index < 0 || index >= this.size) {
            throw  new IndexOutOfBoundsException();
        }
        Node<e> result = this.first;

        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Удаление последнего элемента.
     * @return удалённый элемент.
     */
    public e removeLast() {
        Node<e> removedNode;
        if (size > 1) {
            removedNode = last;
            last = last.prev;
            last.next = null;
            size--;
        } else {
            removedNode = first;
            first = null;
            last = null;
        }
        return removedNode.date;
    }

    /**
     * Удаление первого элемента.
     * @return удалённый элемент.
     */
    public e removeFirst() {
        Node<e> removedNode;
        if (size > 1) {
            removedNode = first;
            first = first.next;
            first.prev = null;
            size--;
        } else {
            removedNode = first;
            first = null;
            last = null;
        }
        return removedNode.date;
    }

    /**
     * Итератор.
     * @return итератор.
     */
    @Override
    public Iterator<e> iterator() {
        return new Iterator<e>() {
            private  int indexPosition;
            private Node<e> next = first;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return indexPosition < size;
            }

            @Override
            public e next() {
                Node<e> result;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    result = next;
                    this.next = next.next;
                    indexPosition++;
                }
                return result.date;
            }
        };
    }
    /**
     * Внутренний класс для создания ссылок на элементы.
     * @param <e> тип данных.
     */
    private static class Node<e> {
        e date;
        Node<e> next;
        Node<e> prev;

        Node(Node<e> prev, e date, Node<e> next) {
            this.date = date;
            this.next = next;
            this.prev = prev;
        }
    }
}
