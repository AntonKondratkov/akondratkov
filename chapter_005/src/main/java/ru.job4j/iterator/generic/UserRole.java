package ru.job4j.iterator.generic;
/**
 * @author Anton Kondratkov
 * @since 09.08.18.
 * Хранилище объектов Role
 */
public class UserRole extends AbstractStore<Role> {
    /**
     * Конструктор класса.
     * @param size размер хранилища.
     */
    public UserRole(int size) {
        super(size);
    }
}
