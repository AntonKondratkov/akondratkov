package ru.job4j.threads.synchronizy;

import java.util.Objects;
/**
 * @author Anton Kondratkov
 * @since 18.09.18.
 * Класс реализует структуру пользователя.
 **/
public class User {
    private int id;
    private int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
    @Override
    public String toString() {
        return id + ": " + amount;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return getId() == user.getId() && getAmount() == user.getAmount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount());
    }
}
