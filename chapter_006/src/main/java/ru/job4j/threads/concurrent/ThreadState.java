package ru.job4j.threads.concurrent;
/**
 * Класс описывает состояние двух нитей: NEW, RUNNABLE, TERMINATED.
 * @author Anton Kondratkov
 * @since 09.05.2020
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> { }, "first"
        );
        System.out.println(first.getName() + " " + first.getState());
        Thread second = new Thread(
                () -> { }, "second"
        );
        System.out.println(second.getName() + " " + second.getState());
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED) {
            System.out.println(first.getName() + " " + first.getState());
        }
        while (second.getState() != Thread.State.TERMINATED) {
            System.out.println(second.getName() + " " + second.getState());
        }
        System.out.println(first.getName() + " " + first.getState());
        System.out.println(second.getName() + " " + second.getState());
        System.out.println(Thread.currentThread().getName() + " complete the work");
    }
}
