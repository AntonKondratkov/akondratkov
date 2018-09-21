package ru.job4j.threads.synchronizy;
/**
 * @author Anton Kondratkov
 * @since 21.09.18.
 * Класс реализует создание двух потоков для работы со структурой данных UserStorage.
 **/
public class TwoThreads {
    public static class Thread1 implements Runnable {
        UserStorage storage;
        public Thread t;

        public Thread1(UserStorage storage) {
            this.storage = storage;
            this.t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            synchronized (storage) {
                try {
                    storage.transfer(3, 2, 150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static class Thread2 implements Runnable {
        UserStorage storage;
        public Thread t;

        public Thread2(UserStorage storage) {
            this.storage = storage;
            this.t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            synchronized (storage) {
                try {
                    storage.transfer(3, 2, 300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
