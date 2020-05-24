package ru.job4j.threads.controltask;
/**
 * Класс реализует последовательную работу двух нитей.
 * Нить А всегда выводит фразу в консоль первой, затем фразу выводит нить В.
 * Нити работают вечно.
 * @author Anton Kondratkov
 * @since 24.05.20.
 */
public class MasterSlaveBarrier {
    /**
     * Данный метод выполняет нить A.
     * Нить выводит фразу в консоль, освобождает монитор и переходит в режим ожидания.
     */
    public synchronized void master() {
            System.out.println("Thread A");
            notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * Данный метод выполняет нить B.
     * Нить выводит фразу в консоль, освобождает монитор и переходит в режим ожидания.
     */
    public synchronized void slave()  {
            System.out.println("Thread B");
            notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MasterSlaveBarrier ms = new MasterSlaveBarrier();
        Thread first = new Thread(
                () -> {
                    while (true) {
                        try {
                            ms.master();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, "A");
        Thread second = new Thread(
                () -> {
                    while (true) {
                        try {
                            ms.slave();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, "B");
        first.start();
        Thread.sleep(500);
        second.start();
        first.join();
        second.join();
    }
}
