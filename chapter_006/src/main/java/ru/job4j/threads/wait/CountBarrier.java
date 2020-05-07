package ru.job4j.threads.wait;

/**
 * @author Anton Kondratkov
 * @since 7.05.20.
 * Класс содержит метод, который блокирует выполнение по условию счётчика.
 */
public class CountBarrier {
    private final Object monitor = this;
    private final int total;
    private int count = 0;
    public CountBarrier(final int total) {
        this.total = total;
    }
    /**
     * Метод изменяет значение переменной count если выполняется условие count != total.
     * Если значения переменных total и count будут равны, то запустится метод notifyAll().
     */
    public void count() {
        synchronized (monitor) {
            while (count != total) {
                count++;
            }
            notifyAll();
        }
    }
    /**
     * Если условие total != count в методе будет истинно, то поток перейдёт в режим ожидания, как только
     * значения переменных total и count будут равны, тело метода выполнится.
     */
    public void await() {
        synchronized (monitor) {
            while (total != count) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " in work");
        }
    }

    public static void main(String[] args) {
        CountBarrier barrier = new CountBarrier(5);
        Thread master = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    barrier.count();
                },
                "Master"
        );
        Thread slave = new Thread(barrier::await, "Slave");

        slave.start();
        master.start();
    }
}
