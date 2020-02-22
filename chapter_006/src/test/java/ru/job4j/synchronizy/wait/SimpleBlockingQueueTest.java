package ru.job4j.synchronizy.wait;

import org.junit.Test;
import ru.job4j.threads.wait.SimpleBlockingQueue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Kondratkov
 * @since 19.01.19.
 * Тестирование класса SimpleBlockingQueue.
 **/
public class SimpleBlockingQueueTest {
    /**
     *  Данный метод проверяет добавление одного элемента в очередь и его извлечение.
     * @throws InterruptedException
     */
    @Test
    public void whenAddElementToQueue() throws InterruptedException {
        SimpleBlockingQueue<Integer> sb = new SimpleBlockingQueue<>();
        int[] result = new int[1];
        Thread producer = new Thread(() -> {
            try {
                sb.offer(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
               result[0] = sb.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();


        assertThat(result[0], is(1));
    }
    /**
     * Данный метод проверяет добавление 5 элементов в очередь и их извлечение.
     * @throws InterruptedException
     */
    @Test
    public void whenAddSeveralElementToQueue() throws InterruptedException {
        SimpleBlockingQueue<Integer> sb = new SimpleBlockingQueue<>();
        int[] result = new int[5];
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    sb.offer(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    result[i] = sb.poll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();


        assertThat(result[0], is(0));
        assertThat(result[1], is(1));
        assertThat(result[2], is(2));
        assertThat(result[3], is(3));
        assertThat(result[4], is(4));
    }
}
