package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;
/**
 *Class ArrayDuplicateTest в данном классе происходит тестирование класса ArrayDuplicate.
 *@author Anton Kondratkov
 *@since 01.11.2017
 */
public class ArrayDuplicateTest{
    /**
     * Метод тестирует метод ArrayDuplicate.removeDuplicate() для массива {"Привет", "Мир", "Привет", "Супер", "Мир"}.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate(){
        //создаём объект.
        ArrayDuplicate duplicate = new ArrayDuplicate();
        //передаём заданный массив в метод removeDuplicate.
        String[] strings = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = duplicate.removeDuplicate(strings);
        // Задаем ожидаемый результат.
        String[] expected = {"Привет", "Мир", "Супер"};
        //Проверяем результат и ожидаемое значение.
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
}