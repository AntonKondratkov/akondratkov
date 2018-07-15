package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Class RotateArrayTest в данном классе происходит тестирование класса RotateArray.
 *@author Anton Kondratkov
 *@since 25.11.2017
 */
public class RotateArrayTest {
    /**
     * Метод тестирует метод RotateArray.rotate() для массива {{inheritance, 2},{3, 4}}.
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        //создаём объект.
        RotateArray getRotate = new RotateArray();
        //передаём заданный массив в метод rotate.
        int[][] input = {{1, 2}, {3, 4}};
        int[][] result = getRotate.rotate(input);
        // Задаем ожидаемый результат.
        int[][] expected = {{3, 1}, {4, 2}};
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
    /**
     * Метод тестирует метод RotateArray.rotate() для массива {{inheritance, 2, 3},{4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        //создаём объект.
        RotateArray turn = new RotateArray();
        //передаём заданный массив в метод rotate.
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = turn.rotate(input);
        // Задаем ожидаемый результат.
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));

    }
}