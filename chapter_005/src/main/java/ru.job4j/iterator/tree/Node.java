package ru.job4j.iterator.tree;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс описывает элемент дерева.
 *@author Anton Kondratkov
 *@since 18.07.2019
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    public E getValue() {
        return value;
    }
}
