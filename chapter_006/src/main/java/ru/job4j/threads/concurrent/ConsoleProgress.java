package ru.job4j.threads.concurrent;
/**
 * Класс используется для вывода процесса загрузки в консоль.
 * @author Anton Kondratkov
 * @since 09.05.2020
 */
public class ConsoleProgress implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.print("\r load: " + "-");
            System.out.print("\r load: " + "\\");
            System.out.print("\r load: " + "|");
            System.out.print("\r load: " + "/");
            System.out.print("\r load: " + "-");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(10000);
        progress.interrupt();
    }
}
