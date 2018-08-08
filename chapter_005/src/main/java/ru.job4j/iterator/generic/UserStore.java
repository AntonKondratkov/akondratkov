package ru.job4j.iterator.generic;
/**
 * @author Anton Kondratkov
 * @since 09.08.18.
 * Хранилище объектов User
 */
public class UserStore extends AbstractStore<User> {
    /**
     * Конструктор класса.
     * @param size размер хранилища.
     */
    public UserStore(int size) {
        super(size);
    }
}
