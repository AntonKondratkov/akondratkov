package ru.job4j.iterator;

import org.junit.Test;
import ru.job4j.iterator.generic.SimpleArray;
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
}
