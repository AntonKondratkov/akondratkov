package ru.job4j.iterator.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Проверка класса SimpleSet.
 */
public class SimpleSetTest {

    private SimpleSet<Integer> simpleSet = new SimpleSet<>();

    @Test
    public void whenAddToSetSameElement() {
        simpleSet.add(1);
        simpleSet.add(1);

        Object result = null;

        assertThat(simpleSet.get(0), is(1));
        assertThat(simpleSet.get(1), is(result));

    }

    @Test
    public void checkIterator() {
        Iterator<Integer> it = simpleSet.iterator();
        simpleSet.add(1);
        simpleSet.add(2);

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));

    }
}
