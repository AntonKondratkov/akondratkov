package ru.job4j.threads.pool;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 21.05.20.
 * Тестирование класса ThreadPool.
 **/
public class ThreadPoolTest {
    @Test
    public void whenRandomNumbersAddToList() {
        ThreadPool threadPool = new ThreadPool();
        List<Integer> numbers = new ArrayList<>();
        int expected = 10;
        threadPool.work(() -> {
            for (int i = 0; i < 10; i++) {
                numbers.add(new Random().nextInt(100));
            }
            assertThat(numbers.size(), is(expected));
        });
        threadPool.shutdown();
    }
}