package ru.job4j.iterator.generic;
/**
 * @author Anton Kondratkov
 * @since 09.08.18.
 * Абстарктный класс для моделей c методами String getId().
 */
public abstract class Base {
    private final String id;
    private final String name;
    /**
     * Конструткор класса.
     * @param id номер модели.
     * @param name Название модели.
     */
    protected Base(final String id, final String name) {
        this.id = id;
        this.name = name;
    }
    /**
     * Установка номера модели.
     * @return возврат номера.
     */
    public String getId() {
        return id;
    }
    /**
     * Установка названия модели.
     * @return возврат названия.
     */
    public String getName() {
        return name;
    }
}
