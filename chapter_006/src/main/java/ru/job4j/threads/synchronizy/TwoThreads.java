package ru.job4j.threads.synchronizy;
/**
 * @author Anton Kondratkov
 * @since 12.11.18.
 * Класс реализует создание двух потоков для работы со структурой данных UserStorage.
 **/
public class TwoThreads extends Thread {
    private final UserStorage storage;
    private User user1;
    private User user2;
    private int amount;

    public TwoThreads(User user1, User user2, int amount, UserStorage storage) {
        this.user1 = user1;
        this.user2 = user2;
        this.amount = amount;
        this.storage = storage;
    }
    @Override
    public void run() {
        synchronized (storage) {
            try {
                storage.transfer(user1.getId(), user2.getId(), amount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
