package ru.job4j.iterator.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 25.08.18.
 * Проверка класса AsLinkedList.
 */
public class AsLinkedListTest {

    private AsLinkedList<Integer> array = new AsLinkedList<>();
    private Iterator<Integer> iterator = array.iterator();

    /**
     * Проверка метода addLast.
     */
    @Test (expected = ConcurrentModificationException.class)
    public void whenAddLastElementToAsLinkedList() {

        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        assertThat(array.get(0), is(1));
        assertThat(array.get(1), is(2));
        assertThat(array.get(2), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }
    /**
     * Проверка метода addFirst.
     */
    @Test (expected = ConcurrentModificationException.class)
    public void whenAddFirstElementToAsLinkedList() {
        array.addFirst(1);
        array.addFirst(2);
        array.addFirst(3);
        assertThat(array.get(0), is(3));
        assertThat(array.get(1), is(2));
        assertThat(array.get(2), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }
    /**
     * Проверка метода removeFirst.
     */
    @Test
    public void whenRemoveFirst() {
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        assertThat(array.removeFirst(), is(1));
        assertThat(array.get(0), is(2));
        assertThat(array.removeFirst(), is(2));
        assertThat(array.get(0), is(3));
        assertThat(array.removeFirst(), is(3));
    }
    /**
     * Проверка метода removeLast.
     */
    @Test
    public void whenRemoveLast() {
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        assertThat(array.get(2), is(3));
        assertThat(array.removeLast(), is(3));
        assertThat(array.get(1), is(2));
        assertThat(array.removeLast(), is(2));
        assertThat(array.get(0), is(1));
        assertThat(array.removeLast(), is(1));
    }
}

