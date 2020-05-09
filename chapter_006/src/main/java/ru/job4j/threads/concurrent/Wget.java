package ru.job4j.threads.concurrent;
/**
 * Класс содержит метод main, который симулирует процесс загрузки.
 * @author Anton Kondratkov
 * @since 09.05.2020
 */
public class Wget {
    /**
     * Метод print печатает символы в строку без перевода каретки.
     * Символ \r указывает, что каретку каждый раз нужно вернуть в начало строки.
     * Это позволяет через промежуток времени обновить строчку
     * @param args args
     */
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(1000);
                            System.out.print("\rLoading : " + i + "%");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        first.start();
    }
}
