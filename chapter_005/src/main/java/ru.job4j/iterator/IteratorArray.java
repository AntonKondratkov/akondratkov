package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class IteratorArray. Итератор для двумерного массива.
 * @author Anton Kondratkov
 * @since 29.07.2018
 */
public class IteratorArray implements Iterator {

    private final int[][] values;
    private int indexCols = 0;
    private int indexRows = 0;

    public IteratorArray(int[][] values) {
        this.values = values;
    }
    /**
     * Метод проверяет наличие следующего элемента.
     * @return Возвращает true - если в массиве есть следующий элемент,
     * false - если следующего элемента нет.
     */
    @Override
    public boolean hasNext() {

        boolean indicator = true;

        if (values[indexRows].length == indexCols && (indexRows + 1) == values.length) {
            indicator = false;
        }
        return indicator;
    }
    /**
     * Метод перебирает элементы массива.
     * @return Возвращает текущий элемент и передвигает каретку на одну позицию вперёд.
     */
    @Override
    public Object next() {

        if (values.length == 0) {
            throw  new NoSuchElementException("No elements");
        }
        if (values[indexRows].length == indexCols) {
            indexRows++;
            indexCols = 0;
        }
        return values[indexRows][indexCols++];
    }
}








