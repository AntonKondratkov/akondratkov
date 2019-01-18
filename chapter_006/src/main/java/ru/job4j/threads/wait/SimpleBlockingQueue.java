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
    private final int LIMIT = 2;

    public void offer(T value) throws InterruptedException {
        synchronized (this) {
            while (queue.size() == LIMIT) {
                wait();
            }
            queue.offer(value);
            notify();
        }
    }

    public T poll() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this) {
            while (queue.size() == 0) {
                wait();
            }
            notify();
        }
        return queue.poll();
    }
}