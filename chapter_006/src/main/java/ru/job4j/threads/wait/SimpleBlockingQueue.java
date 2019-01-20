package ru.job4j.threads.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * @author Anton Kondratkov
 * @since 19.01.19.
 * Класс реализует шаблон Producer Consumer.
 **/

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private final int LIMIT = 1;

    public void offer(T value) throws InterruptedException {
        synchronized (this) {
            notify();
            while (queue.size() == LIMIT) {
                wait();
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