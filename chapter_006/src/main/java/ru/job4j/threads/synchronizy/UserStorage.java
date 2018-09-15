package ru.job4j.threads.synchronizy;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class UserStorage {
    private int count = 0;
    private final User[] users = new User[3];

    public boolean add(User user) {
        boolean result = false;
        synchronized (users) {
            users[count++] = user;
            return true;
        }
    }

    public boolean update(User user) {
        boolean result = false;
        synchronized (users) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].equals(user)) {
                    users[i] = user;
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean delete(User user) {
        boolean result = false;
        synchronized (users) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].equals(user)) {
                    System.arraycopy(users,i + 1, users, i, users.length - i);
                    result = true;
                }
            }
        }
        return result;
    }

    public synchronized void transfer (int fromId, int told, int amount) {

    }
}

class User {
    private final int id;
    private final int amount;

    User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}
