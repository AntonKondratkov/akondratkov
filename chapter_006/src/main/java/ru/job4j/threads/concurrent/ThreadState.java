package ru.job4j.threads.concurrent;
/**
 * Класс описывает состояние двух нитей: NEW, RUNNABLE, TERMINATED.
 * @author Anton Kondratkov
 * @since 09.05.2020
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(
                () -> { }, "first"
        );
        System.out.println(first.getName() + " " + first.getState());
        first.start();
        while (first.getState() != Thread.State.TERMINATED) {
            System.out.println(first.getName() + " " + first.getState());
        }
        System.out.println(first.getName() + " " + first.getState());

        Thread second = new Thread(
                () -> { }, "second"
        );
        System.out.println(second.getName() + " " + second.getState());
        second.start();
        System.out.println(second.getName() + " " + second.getState());
        second.join();
        System.out.println(second.getName() + " " + second.getState());

        System.out.println(Thread.currentThread().getName() + " complete the work");
    }
}
