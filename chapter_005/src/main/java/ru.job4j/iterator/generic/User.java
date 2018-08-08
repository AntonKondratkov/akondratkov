package ru.job4j.iterator.generic;
/**
 * @author Anton Kondratkov
 * @since 09.08.18.
 * Класс User наследует абстрактный класс Base.
 */
public class User extends Base {
    /**
     * Конструктор класса.
     * @param id номер модели.
     * @param name название модели.
     */
    protected User(String id, String name) {
        super(id, name);
    }
}
