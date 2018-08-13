package ru.job4j.iterator.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Kondratkov
 * @since 13.08.18.
 * Тестирование класса DynamicArray.
 **/
public class DynamicArrayTest {

    private DynamicArray<Integer> array;

    @Before
    public void beforeTest() {
        array = new DynamicArray<>(2);
        array.add(1);
        array.add(2);
    }
    /**
     * Проверка метода add.
     */
    @Test (expected = ConcurrentModificationException.class)
    public void whenAddElementToDynamicArray() {
        array.add(3);
        array.checkForComodification();
        assertThat(array.get(2), is(3));
    }
    /**
     *  Проверка метода iterator.
     */
    @Test ()
    public void whenIteratorInDynamicArray() {
        Iterator<Integer> iterator = array.iterator();
        array.add(3);
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }
}
