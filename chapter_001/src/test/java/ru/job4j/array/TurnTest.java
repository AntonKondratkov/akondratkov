package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Class TurnTest в данном классе происходит тестирование класса Turn.
 *@author Anton Kondratkov
 *@since 20.11.2017
 */

public class TurnTest {
    /**
     * Метод тестирует метод Turn.reverse() для массива {2, 6, 1, 4}.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        //создаём объект.
        Turn turn = new Turn();
        //передаём заданный массив в метод reverse.
        int[] input = {2, 6, 1, 4};
        int[] result = turn.reverse(input);
        // Задаем ожидаемый результат.
        int[] expected = {4, 1, 6, 2};
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
    /**
     * Метод тестирует метод Turn.reverse() для массива {1, 2, 3, 4, 5}.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        //создаём объект.
        Turn turn = new Turn();
        //передаём заданный массив в метод reverse.
        int[] input = {1, 2, 3, 4, 5};
        int[] result = turn.reverse(input);
        // Задаем ожидаемый результат.
        int[] expected = {5, 4, 3, 2, 1};
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
}