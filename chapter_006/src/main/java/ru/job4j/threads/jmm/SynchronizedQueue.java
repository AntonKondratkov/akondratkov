package ru.job4j.threads.jmm;
/**
 * @author Anton Kondratkov
 * @since 14.09.2018
 * В данном классе рассматривается организация очереди.
 */
class SynchronizedQueue {
    int n;
    synchronized int get() {
        System.out.println("Получено: " + n);
        return n;
    }

    synchronized void put(int n) {
        this.n = n;
        System.out.println("Отправлено: " + n);
    }
}

class Producer implements Runnable {
    SynchronizedQueue q;
    Producer(SynchronizedQueue q) {
        this.q = q;
        new Thread(this, "Поставщик").start();
    }

    @Override
    public void run() {
        int i = 0;

        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    SynchronizedQueue q;

Consumer(SynchronizedQueue q) {
    this.q = q;
    new Thread(this, "Потребитель").start();
}
    @Override
    public void run() {
    while (true) {
        q.get();
    }
    }
}

class Generate {
    public static void main(String[] args) {
        SynchronizedQueue q = new SynchronizedQueue();
        new Producer(q);
        new Consumer(q);

        System.out.println("Для остановки нажмите Ctrl+C.");
    }
}