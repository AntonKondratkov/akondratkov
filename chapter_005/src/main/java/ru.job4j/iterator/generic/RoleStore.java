package ru.job4j.iterator.generic;
/**
 * @author Anton Kondratkov
 * @since 09.08.18.
 * Хранилище объектов Role
 */
public class RoleStore extends AbstractStore<Role> {
    /**
     * Конструктор класса.
     * @param size размер хранилища.
     */
    public RoleStore(int size) {
        super(size);
    }
}
