package ru.job4j.iterator.set;


import ru.job4j.iterator.generic.SimpleArray;

/**
 * Коллекция set на массиве.
 * @param <T> тип данных.
 */
public class SimpleSet<T>  {
    /**
     * Объект класса SimpleArray.
     */
    private SimpleArray<T> array = new SimpleArray<>(2);
    /**
     * Метод добавляет новые элементы.
     * @param model добавляемый элемент.
     */
    public void add(T model) {
        if (!array.contains(model)) {
            array.add(model);
        }
    }
    /**
     * Метод получает значение по индексу.
     * @param index позиция в массиве.
     * @return найденная позиция.
     */
    public T get(int index) {
        return array.get(index);
    }
}
