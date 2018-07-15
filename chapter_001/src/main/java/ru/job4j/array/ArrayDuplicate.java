package ru.job4j.array;

import java.util.Arrays;
/**
 *Class ArrayDuplicate в данном классе происходит удаление дубликатов в передаваемом массиве.
 *@author Anton Kondratkov
 *@since 01.11.2017
 */
public class ArrayDuplicate {
    /**
     * Метод removeDuplicate убирает все дубликаты из строк массива.
     * @param array - входной массив с дубликатами.
     * @return array без дубликатов.
     */
    public String[] removeDuplicate(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }

        }
        return Arrays.copyOf(array, unique);
    }
}
