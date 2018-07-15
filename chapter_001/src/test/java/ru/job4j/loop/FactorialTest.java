package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *@author Anton Kondratkov
 *@since 17.11.2017
 */

public class FactorialTest {
    @Test
     public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        //создаём объект.
        Factorial sum = new Factorial();
        //задаём число для вычисления факториала.
        int result = sum.calc(5);
        // Задаем ожидаемый результат.
        int expected = 120;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        //создаём объект.
        Factorial sum = new Factorial();
        //задаём число для вычисления факториала.
        int result = sum.calc(0);
        // Задаем ожидаемый результат.
        int expected = 1;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
}
