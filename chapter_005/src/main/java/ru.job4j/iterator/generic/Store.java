package ru.job4j.iterator.generic;
/**
 * @author Anton Kondratkov
 * @since 09.08.18.
 * Интерфейс содержит методы для хранилищ.
 **/
public interface Store<T extends Base> {
    /**
     * Добавление объекта в хранилище.
     * @param model добавляемы объект.
     * @return добавленный объект.
     */
    Base add(T model);
    /**
     * Замена объекта в хранилище.
     * @param id номер заменяемого объекта.
     * @param model новый объект.
     * @return подтверждение замены существующего объекта на новый.
     */
    boolean replace(String id, T model);
    /**
     * Удаление объекта из хранилища.
     * @param id номер удаляемого объекта.
     * @return подтверждение удаления объекта.
     */
    boolean delete(String id);
    /**
     * Поиск объекта в хранилище.
     * @param id номер искомого объекта.
     * @return найденный объект.
     */
    T findById(String id);
}
