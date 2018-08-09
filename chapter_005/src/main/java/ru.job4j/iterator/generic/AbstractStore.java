package ru.job4j.iterator.generic;
/**
 * Общий функционал для хранилищ UserStore и RoleStore.
 * @param <E> Тип хранимых данных.
 */
public class AbstractStore<T extends Base> implements Store<T> {
    /**
     * Размер хранилища.
     */
    private int size;
    /**
     * Хранилище.
     */
    private SimpleArray<T> simple;
    private T model;

    /**
     * Конструктор.
     * @param size Размер хранилища.
     */
    public AbstractStore(int size) {
        this.size = size;
        this.simple = new SimpleArray<>(size);
    }
    /**
     * Добавление объекта в хранилище.
     * @param model добавляемый объект.
     * @return добавленный объект.
     */
    public T add(T model) {
        simple.add(model);
        return model;
    }
    /**
     * Замена объекта в хранилище.
     * @param id номер заменяемого объекта.
     * @param model новый объект.
     * @return подтверждение замены существующего объекта на новый.
     */
    public boolean replace(String id, T model) {
        boolean indicator = false;
        for (int i = 0; i < size; i++) {
            if (simple.get(i) != null && simple.get(i).getId().equals(id)) {
                simple.set(i, (T) model);
                indicator = true;
                break;
            }
        }
        return indicator;
    }
    /**
     * Удаление объекта из хранилища.
     * @param id номер удаляемого объекта.
     * @return подтверждение удаления объекта.
     */
    public boolean delete(String id) {
        boolean indicator = false;
        for (int i = 0; i < size; i++) {
            if (id.equals(simple.get(i).getId())) {
                indicator = simple.delete(i);
            }
        }
        return indicator;
    }
    /**
     * Поиск объекта в хранилище.
     * @param id номер искомого объекта.
     * @return найденный объект.
     */
    public T findById(String id) {
        T result = null;
        for (int i = 0; i < size; i++) {
            if (id.equals(simple.get(i).getId())) {
                result = simple.get(i);
            }
        }
        return result;
    }
}