package ru.job4j.threads.algoritm;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * Тестирование класса CASQueue.
 * @author Anton Kondratkov.
 * @since 17.05.2020.
 */
public class CASQueueTest {
    @Test
    public void when3PushThen3Poll() {
        CASQueue<Integer> queue = new CASQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }
    @Test
    public void when1PushThen1Poll() {
        CASQueue<Integer> queue = new CASQueue<>();
        queue.push(1);
        assertThat(queue.poll(), is(1));
    }
    @Test
    public void when2PushThen2Poll() {
        CASQueue<Integer> queue = new CASQueue<>();
        queue.push(1);
        queue.push(2);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
    }
}