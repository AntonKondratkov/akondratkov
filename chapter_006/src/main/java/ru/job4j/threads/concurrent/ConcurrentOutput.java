package ru.job4j.threads.concurrent;
/**
 * Класс показывает создание двух нитей с использованием интерфейса Runnable.
 * @author Anton Kondratkov
 * @since 08.05.2020
 */
public class ConcurrentOutput {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> System.out.println(Thread.currentThread().getName()), "Thread #1"
        );
        first.start();
        Thread second = new Thread(
                () -> System.out.println(Thread.currentThread().getName()), "Thread #2"
        );
        second.start();
        System.out.println(Thread.currentThread().getName());
    }
}
