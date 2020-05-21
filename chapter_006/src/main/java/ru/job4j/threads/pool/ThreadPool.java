package ru.job4j.threads.pool;

import ru.job4j.threads.wait.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;
/**
 * @author Anton Kondratkov
 * @since 21.05.20.
 * Класс реализует упрощённый пул потоков.
 **/
public class ThreadPool {
    /**
     * Список содержит потоки, которые будут выполнять переданные задачи.
     */
    private final List<Thread> threads = new LinkedList<>();
    /**
     * Очередь содержит задачи, которые необходимо выполнить.
     */
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    /**
     * Конструктор ThreadPool.
     * В конструкторе происходит запуск потоков из пула.
     */
    public ThreadPool() {
        int coreSize = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < coreSize; i++) {
            threads.add(new TasksAdd());
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
    /**
     * Метод добавляет задачи в очередь.
     * @param job добавляемая задача.
     */
    public void work(Runnable job) {
        if (!Thread.currentThread().isInterrupted()) {
            tasks.offer(job);
        }
    }
    /**
     * Метод останавливает выполнение потоков из пула и очищает пул от потоков.
     */
    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
        threads.clear();
    }
    /**
     * В данном классе происходит извлечение задачи из очереди и её выполнение.
     */
    private final class TasksAdd extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                Runnable runnable;
                try {
                    runnable = tasks.poll();
                    if (runnable != null) {
                        runnable.run();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
