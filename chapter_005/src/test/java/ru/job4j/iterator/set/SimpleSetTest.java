package ru.job4j.iterator.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Проверка класса SimpleSet.
 */
public class SimpleSetTest {
    @Test
    public void whenAddToSetSameElement() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>(2);
        simpleSet.add(1);
        simpleSet.add(1);

        Object result = null;

        assertThat(simpleSet.get(0), is(1));
        assertThat(simpleSet.get(1), is(result));
    }
}
