package ru.job4j.iterator.generic;
/**
 * @author Anton Kondratkov
 * @since 09.08.18.
 * Класс Role наследует абстрактный класс Base.
 */
public class Role extends Base {
    /**
     * Конструктор класса.
     * @param id номер модели.
     * @param name название модели.
     */
    protected Role(String id, String name) {
        super(id, name);
    }
}
