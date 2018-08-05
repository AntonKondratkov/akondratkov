package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class IteratorArray. Итератор для двумерного массива.
 * @author Anton Kondratkov
 * @since 05.08.2018
 */
public class IteratorArray implements Iterator {

    private final int[][] values;
    private int indexRows;
    private int indexCols;

    public IteratorArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean indicator = true;
        if (indexRows >= values.length) {
            indicator = false;
        } else if (values[indexRows].length <= indexCols) {
            indicator = false;
        }
        return indicator;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No elements");
        }
        int result = values[indexRows][indexCols++];
        if (values[indexRows].length == indexCols) {
            indexRows++;
            indexCols = 0;
        }
        return result;
    }
}