package ru.job4j.threads.controltask;

import net.jcip.annotations.ThreadSafe;

/**
 * Класс реализует последовательную работу двух нитей.
 * Нить А всегда выводит фразу в консоль первой, затем фразу выводит нить В.
 * Нити работают вечно.
 * @author Anton Kondratkov
 * @since 24.05.20.
 */
@ThreadSafe
public class MasterSlaveBarrier {
    /**
     * Флаг работы потока "A".
     */
    boolean master = true;
    /**
     * Флаг работы потока "B".
     */
    boolean slave = false;
    /**
     * Данный метод выполняет поток "A".
     * Выводит в консоль своё имя, вызывает метод doneMaster(), затем переходит в режим ожидания.
     * @throws InterruptedException Выбрасывается если другой поток прервал ждущий текущий поток.
     */
    public synchronized void tryMaster() throws InterruptedException {
        while (master) {
            System.out.println(Thread.currentThread().getName());
            doneMaster();
        }
        wait();
    }
    /**
     * Данный метод выполняет поток "B".
     * Выводит в консоль своё имя, вызывает метод doneSlave(), затем переходит в режим ожидания.
     * @throws InterruptedException Выбрасывается если другой поток прервал ждущий текущий поток.
     */
    public synchronized void trySlave() throws InterruptedException {
        while (slave) {
            System.out.println(Thread.currentThread().getName());
            doneSlave();
        }
        wait();
    }
    /**
     * Метод меняет значения флагов, пробуждает ждущий поток.
     * Вызывается из метода tryMaster.
     */
    public synchronized void doneMaster() {
        master = false;
        slave = true;
        notifyAll();
    }
    /**
     * Метод меняет значения флагов, пробуждает ждущий поток.
     * Вызывается из метода trySlave.
     */
    public synchronized void doneSlave() {
        master = true;
        slave = false;
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        MasterSlaveBarrier ms = new MasterSlaveBarrier();
        Thread first = new Thread(
                () -> {
                    while (true) {
                        try {
                            ms.tryMaster();
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
                            ms.trySlave();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, "B");
        first.start();
        second.start();
        first.join();
        second.join();
    }
}
