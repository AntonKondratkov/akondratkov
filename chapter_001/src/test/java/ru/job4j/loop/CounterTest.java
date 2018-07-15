package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *@author Anton Kondratkov
 *@since 17.11.2017
 */

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        //создаём объект.
        Counter sum = new Counter();
        //задаём диапазон чисел.
        int result = sum.add(1, 10);
        // Задаем ожидаемый результат.
        int expected = 30;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
}

