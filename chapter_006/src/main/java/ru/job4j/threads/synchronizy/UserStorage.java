package ru.job4j.threads.synchronizy;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @author Anton Kondratkov
 * @since 18.09.18.
 * Класс реализует структуру данных для хранения пользователей.
 **/

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private int count = 0;
    private final User[] users = new User[3];
    /**
     * Метод добавляет пользователя в хранилище.
     * @param user Добавляемый пользователь.
     * @return true или false, пользователь добавился или не добавился.
     */
    public boolean add(User user) {
        synchronized (users) {
            users[count++] = user;
        }
        return true;
    }
    /**
     * Метод обновляет данные пользователя.
     * @param user Пользователь данные которого необходимо обновить.
     * @return result.
     */
    public boolean update(User user) {
        boolean result = false;
        synchronized (users) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].getId() == user.getId()) {
                    users[i] = user;
                    result = true;
                }
            }
        }
        return result;
    }
    /**
     * Метод удаляет пользователя из хранилища.
     * @param user Пользователь, которого необходимо удалить.
     * @return result.
     */
    public boolean delete(User user) {
        boolean result = false;
        synchronized (users) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].equals(user)) {
                    System.arraycopy(users, i + 1, users, i, users.length - i - 1);
                    result = true;
                }
            }
        }
        return result;
    }
    /**
     * Метод получает объект из хранилища.
     * @param index
     * @return
     */
    public User getUser(int index) {
        return users[index];
    }
    /**
     * Метод осуществляет перевод суммы от одного пользователя к другому.
     * @param fromId id первого пользователя.
     * @param told id второго пользователя.
     * @param amount суммау, которую необходимо перевести.
     * @return result.
     * @throws InterruptedException
     */
    public boolean transfer(int fromId, int told, int amount) throws InterruptedException {
        boolean result = false;

        User from = users[fromId - 1];
        User to = users[told - 1];

        if (from.getAmount() >= amount) {
            synchronized (from) {
                Thread.sleep(500);
                from.setAmount(from.getAmount() - amount);
                update(from);
            }
            synchronized (to) {
                to.setAmount(to.getAmount() + amount);
                update(to);
            }
            result = true;
        }
        return result;
    }
}