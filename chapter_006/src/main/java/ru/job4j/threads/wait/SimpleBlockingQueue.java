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

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private final int LIMIT = 10;

    public void offer(T value) throws InterruptedException {
        for (int i = 0; i < 13; i++) {
            synchronized (this) {
                while (queue.size() == LIMIT) {
                    System.out.println("Вызов метода wait в методе offer");
                    wait();
                }
                queue.offer(value);
                notify();
            }
        }
    }

    public void poll() throws InterruptedException {
        for (int i = 0; i < 13; i++) {
            synchronized (this) {
                while (queue.size() == 0) {
                    System.out.println("Вызов метода wait в методе poll");
                    wait();
                }
                System.out.println(queue.poll());
                Thread.sleep(1000);
                notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue sb = new SimpleBlockingQueue();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sb.offer(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sb.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}