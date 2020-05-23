package ru.job4j.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Класс реализует сервис для рассылки почты.
 * @author Anton Kondratkov.
 * @since 23.05.2020
 */
public class EmailNotification {
    private ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );
    /**
     * Метод отправляет почту (вызывает метод send) используя ExecutorService.
     * @param user Пользователь, которому отправляется email.
     */
    public void emailTo(User user) {
        pool.submit(
                () -> {
                    String subject = String.format("Notification %s to email %s", user.username, user.email);
                    String body = String.format("Add a new event to %s", user.username);
                    String email = user.email;
                    send(subject, body, email);
                });
        close();
    }
    /**
     * Метод закрывает пул потов pool.
     */
    public void close() {
        pool.shutdown();
    }
    /**
     * Пустой метод. Используется для вызова из метода emailTo.
     * @param subject Данные пользователя.
     * @param body Сообщение пользователю.
     * @param email email Пользователя.
     */
    public void send(String subject, String body, String email) {
    }
    /**
     * Класс описывает объект User.
     */
    public static class User {
        String username;
        String email;
        User(String username, String email) {
            this.username = username;
            this.email = email;
        }
    }
}
