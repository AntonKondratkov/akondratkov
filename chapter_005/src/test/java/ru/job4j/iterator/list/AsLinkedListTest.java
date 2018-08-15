package ru.job4j.iterator.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AsLinkedListTest {

    private AsLinkedList<Integer> array;

    @Before
    public void beforeTest() {
        array = new AsLinkedList<>();
        array.add(1);
        array.add(2);
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenAddElementToAsLinkedList() {
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

