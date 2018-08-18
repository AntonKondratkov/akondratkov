package ru.job4j.iterator.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 19.08.18.
 * Тестирование классов SimpleStack и SimpleQueue.
 **/
public class SimpleStackAndQueueTest {
    /**
     * Проверка класса SimpleStack.
     */
    @Test
    public void whenSimpleStack() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);

        Object result = null;

        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.container(2), is(result));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.container(1), is(result));
        assertThat(simpleStack.poll(), is(1));
        assertThat(simpleStack.container(0), is(result));
    }
    /**
     * Проверка класса SimpleQueue().
     */
    @Test
    public void whenSimpleQueue() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);

        Object result = null;

        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.container(2), is(result));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.container(2), is(result));
        assertThat(simpleQueue.poll(), is(3));
        assertThat(simpleQueue.container(2), is(result));
    }
}
