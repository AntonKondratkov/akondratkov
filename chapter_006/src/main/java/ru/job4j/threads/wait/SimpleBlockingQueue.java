package ru.job4j.threads.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @author Anton Kondratkov
 * @since 19.01.19.
 * Класс реализует шаблон Producer Consumer.
 **/

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private final int limit = 1;

    public void offer(T value) {
        synchronized (this) {
            notify();
            while (queue.size() == limit) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(value);
        }
    }

    public T poll() throws InterruptedException {
        synchronized (this) {
            notify();
            while (queue.size() == 0) {
                wait();
            }
        }
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }
}