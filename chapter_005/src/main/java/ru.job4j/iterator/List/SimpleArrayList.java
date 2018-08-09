package ru.job4j.iterator.List;

public class SimpleArrayList<e> {

    private int size;
    private Node<e> first;
    /**
     * Метод вставляет данные в начало списка.
     * @param data добавляемый элемент.
     */
    public void add(e data) {
        Node<e> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Метод удаляет первый элемент в списке.
     * @return удалённый элемент.
     */
    public e delete() {
        Node<e> newFirst;
        newFirst = this.first;
        this.first = newFirst.next;
        size--;
        return newFirst.date;
    }

    /**
     * Метод возвращает элемент по индексу.
     * @param index индекс элемента.
     * @return элемент по заданному индексу.
     */
    public e get(int index) {
        Node<e> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Метод получения размера коллекции.
     * @return размер коллекции.
     */
    public int getSize() {
        return size;
    }

    /**
     * Класс предназначен для хранения данных.
     * @param <e> тип хранимых данных.
     */
    private static class Node<e> {
        e date;
        Node<e> next;

        Node(e date) {
            this.date = date;
        }
    }
}
