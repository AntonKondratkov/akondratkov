package ru.job4j.iterator;

import org.junit.Test;
import ru.job4j.iterator.generic.SimpleArray;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Anton Kondratkov
 * @since 04.08.18.
 * Тестирование класса SimpleArray.
 **/
public class SimpleArrayTest {
    private SimpleArray sa = new SimpleArray(3);
    @Test
    public void whenElementAddToArray() {

        sa.add(1);
        sa.add("test");
        int result = 1;
        String result2 = "test";

        assertThat(result, is(sa.get(0)));
        System.out.println(sa.iterator().hasNext());
        assertThat(result2, is(sa.get(1)));
    }
    @Test
    public void whenElementSetToArray() {
        sa.add(1);
        sa.add("test");
        sa.set(0, "element");

        String result = "element";
        String result2 = "test";

        assertThat(result, is(sa.get(0)));
        assertThat(result2, is(sa.get(1)));

    }
    @Test
    public void whenDeleteElement() {
        sa.add(4);
        sa.add("test");
        sa.delete(1);

        String result = null;

        assertThat(result, is(sa.get(1)));
    }
    @Test
    public void itarator() throws Exception {
        sa.add(1);
        sa.add(2);
        sa.add(3);
        Iterator<Integer> it = sa.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is (1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is (2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is (3));
        assertThat(it.hasNext(), is(false));
    }
}
