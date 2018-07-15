package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Class BubbleSortTest в данном классе происходит тестирование класса BubbleSort.
 *@author Anton Kondratkov
 *@since 25.11.2017
 */
public class BubbleSortTest {
    /**
     * Метод тестирует метод BubbleSort.sort() для массива {inheritance, 5, 4, 2, 3, inheritance, 7, 8, 0, 5}.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //создаём объект.
        BubbleSort bubble = new BubbleSort();
        //передаём заданный массив в метод sort.
        int[] input = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = bubble.sort(input);
        // Задаем ожидаемый результат.
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
}