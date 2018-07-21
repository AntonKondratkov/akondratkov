package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 22.07.18.
 * Данный класс проверяет работу класса PriorityQueue.
 */
public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 0));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 2));
        Task result = queue.take();
        assertThat(result.getDesc(), is("low"));
    }
}
