package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Class ArrayDuplicateTest в данном классе происходит тестирование класса ArrayDuplicate.
 *@author Anton Kondratkov
 *@since 30.11.2017
 */
public class ArrayDuplicateTest {
    /**
     * Метод тестирует метод ArrayDuplicate.remove() для массива {"Привет", "Мир", "Привет", "Супер", "Мир"}.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //создаём объект.
        ArrayDuplicate duplicate = new ArrayDuplicate();
        //передаём заданный массив в метод remove.
        String[] strings = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = duplicate.remove(strings);
        // Задаем ожидаемый результат.
        String[] expected = {"Привет", "Мир", "Супер"};
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
}