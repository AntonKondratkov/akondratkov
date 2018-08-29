package ru.job4j.iterator.Set;

import ru.job4j.iterator.generic.SimpleArray;
/**
 * Коллекция Set на массиве.
 * @param <T> тип данных.
 */
public class SimpleSet<T> extends SimpleArray<T> {
    /**
     * Конструктор
     * @param size длинна массива.
     */
    public SimpleSet(int size) {
        super(size);
    }
    public void add(T model) {
        if (!super.contains(model)) {
            super.add(model);
        }
    }

    public static void main(String[] args) {
        SimpleSet<Integer> simpleSet = new SimpleSet<>(5);
        simpleSet.add(4);
        simpleSet.add(1);
        simpleSet.add(4);
        simpleSet.add(2);
        simpleSet.add(1);
        System.out.println(simpleSet.get(0));
        System.out.println(simpleSet.get(1));
        System.out.println(simpleSet.get(2));
        System.out.println(simpleSet.get(3));
        System.out.println(simpleSet.get(4));

//        System.out.println(simpleSet.get(4));
    }
}
