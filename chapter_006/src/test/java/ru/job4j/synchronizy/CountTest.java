package ru.job4j.synchronizy;

import org.junit.Test;
import ru.job4j.threads.synchronizy.Count;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CountTest {
    private class ThreadCount extends Thread {
        private final Count count;

        private ThreadCount(final Count count) {
            this.count = count;
        }

        public void run() {
            this.count.increment();
        }
    }

    @Test
    public void whenExcute2ThreadThen2() throws InterruptedException {
        //Создаём счетчик.
        final Count count = new Count();
        //Создаём нити.
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);
        //Запускаем нити.
        first.start();
        second.start();
        //Заставляем главную нить дождаться выполнения наших нитей.
        first.join();
        second.join();
        //Проверяем результат.
        assertThat(count.get(), is(2));
    }
}
