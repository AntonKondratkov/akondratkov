package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class EvenIterator. Итератор возвращающий только чётный цифры.
 * @author Anton Kondratkov
 * @since 29.07.2018
 */
public class EvenIterator implements Iterator {

    private final int[] array;
    private int index = 0;

    public EvenIterator(int[] array) {
        this.array = array;
    }
    /**
     * Метод возвращает true если следующее число чётное или
     * false если следующее число нечетное.
     * @return переменная indicator;
     */
    @Override
    public boolean hasNext() {
        boolean indicator = false;
        for (int i = index; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                indicator = true;
                index = i;
                break;
            }
        }
        return indicator;
    }
    /**
     * Метод возвращает только чётные цифры.
     * @return чётные цифры.
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }
}
