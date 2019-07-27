package ru.job4j.iterator.map;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Реализация собственной структуры данных - HashMap
 *@author Anton Kondratkov
 *@since 17.07.2019
 */
public class MyHashMap<K, V> implements Iterable<V> {
    //Массив узлов (пар ключ - значение).
    private Node<K, V>[] table;
    //Счётчик отражающий количество добавлений узлов в массив table.
    private int count;

    public MyHashMap() {
        this.table = (Node<K, V>[]) new Node[1 << 2];
    }
    /**
     * Метод добавляет узел в map.
     * @param key Ключ.
     * @param value Значение.
     * @return false - узел не добавлен, true - узел удалён.
     */
    public boolean insert(K key, V value) {
        if (count >= this.table.length) {
            growSize();
        }
        int address = getAddress(key);
        Node<K, V> element = this.table[address];
        boolean res = false;
        if (element == null || element.key.equals(key)) {
            this.table[address] = new Node<>(key, value);
            count++;
            res = true;
        }
        return res;
    }
    /**
     * Метод возвращает элемент по ключу.
     * @param key Ключ.
     * @return Возвращаемое значение.
     */
    public V get(K key) {
        Node<K, V> element = this.table[getAddress(key)];
        return (element != null && element.key.equals(key)) ? element.value : null;
    }
    /**
     * Метод удаляет узел из map.
     * @param key Ключ узла.
     * @return false - узел не удалён, true - узел удалён.
     */
    public boolean delete(K key) {
        int address = getAddress(key);
        return (this.table[address] != null
                && this.table[address].key.equals(key))
                && ((this.table[address] = null) == null);
    }
    /**
     * Метод возвращает адрес объекта в списке.
     * @param e Ключ.
     * @return адрес объекта в формате int.
     */
    private int getAddress(K e) {
        return e.hashCode() & (this.table.length - 1);
    }
    /**
     * Метод увеличивает размер таблицы.
     */
    private void growSize() {
        Node<K, V>[] oldContainer = this.table;
        int newSize = this.table.length << 1;
        this.table = (Node<K, V>[]) new Node[newSize];
        for (int i = 0; i < oldContainer.length; i++) {
            Node<K, V> current = oldContainer[i];
            if (current != null) {
                this.table[getAddress(current.key)] = current;
            }
        }
    }
    /**
     * Класс содержит описание узла.
     * @param <K> Ключ.
     * @param <V> Значение.
     */
    static class Node<K, V> {
        final K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    @Override
    public Iterator<V> iterator() {
        return new MyIterator();
    }
    /**
     * Класс описывает работу итератора.
     */
    private class MyIterator implements Iterator {
        boolean doNext;
        int pos;
        int lastPos;

        public MyIterator() {
            this.pos = 0;
            this.lastPos = -1;
        }
        /**
         * Метод определяет есть ли в списке следующий элемент.
         * @return false - элемента нет, true - элемент есть.
         */
        @Override
        public boolean hasNext() {
            while (pos < table.length && table[pos] == null) {
                pos++;
            }
            return pos < table.length;
        }
        /**
         * Метод возвращает следующий элемент в списке.
         * @return возвращаемый элемент.
         */
        @Override
        public Object next() {
            if (hasNext()) {
                doNext = true;
                this.lastPos = this.pos;
                return table[this.pos++].value;
            } else {
                throw new NoSuchElementException();
            }
        }
        /**
         * Метод удаляет элемент из списка.
         */
        @Override
        public void remove() {
            if (lastPos == -1) {
                throw new IllegalStateException();
            } else {
                table[lastPos] = null;
                lastPos = -1;
            }
        }
    }
}
