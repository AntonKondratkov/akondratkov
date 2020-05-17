package ru.job4j.threads.algoritm;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;
/**
 * Класс реализует многопоточную очередь.
 * @author Anton Kondratkov.
 * @since 17.05.2020.
 * @param <T> Тип элементов, которые хранят объекты в очереди.
 */
@ThreadSafe
public class CASQueue<T> {
    private final AtomicReference<Node<T>> head = new AtomicReference<>();
    private final AtomicReference<Node<T>> tail = new AtomicReference<>();
    /**
     * Метод добавляет новый элемент в очередь.
     * @param value Добавляемый элемент.
     */
    public void push(T value) {
        Node<T> h = head.get();
        Node<T> temp = new Node<>(value);
        temp.next = h;
        do {
            if (h == null) {
                tail.set(temp);
            } else {
                h.prev = temp;
            }
        } while (!head.compareAndSet(h, temp));
    }
    /**
     * Метод получает значение элемента из очереди.
     * @return Значение элемента.
     */
    public T poll() {
        Node<T> ref = tail.get();
        Node<T> temp = ref.prev;
        ref.prev = null;
        ref.next = null;
        do {
            if (temp == null) {
                head.set(null);
            } else {
                temp.next = null;
            }
        } while (!tail.compareAndSet(ref, temp));
        return ref.value;
    }
    /**
     * Класс описывает объект, который будет добавляться в очередь.
     * @param <T> Тип элемента, который хранит объект.
     */
    private static final class Node<T> {
        final T value;
        Node<T> next;
        Node<T> prev;
        public Node(final T value) {
            this.value = value;
        }
    }
}
