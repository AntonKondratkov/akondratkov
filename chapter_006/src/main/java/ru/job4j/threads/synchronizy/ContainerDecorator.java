package ru.job4j.threads.synchronizy;

import ru.job4j.iterator.list.DynamicArray;

import java.util.Iterator;

import net.jcip.annotations.ThreadSafe;
import net.jcip.annotations.GuardedBy;

@ThreadSafe
public class ContainerDecorator<E> implements SimpleContainer<E> {

    @GuardedBy("this")
    private DynamicArray<E> container;

    public ContainerDecorator(DynamicArray<E> container) {
        this.container = container;
    }

    @Override
    public synchronized void add(E value) {
        container.add(value);
    }

    @Override
    public synchronized E get(int index) {
        return container.get(index);
    }

    @Override
    public synchronized int getSize() {
        return container.getSize();
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return this.container.copy().iterator();
    }
}
