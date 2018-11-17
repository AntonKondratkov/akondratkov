package ru.job4j.threads.synchronizy;

public interface SimpleContainer<E> extends Iterable<E> {

    void add(E value);

    E get(int index);

    int getSize();
}
