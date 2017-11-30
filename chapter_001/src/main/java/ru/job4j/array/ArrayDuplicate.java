package ru.job4j.array;

import java.util.Arrays;
/**
 *Class ArrayDuplicate в данном классе происходит удаление дубликатов в передаваемом массиве.
 *@author Anton Kondratkov
 *@since 30.11.2017
 */
public class ArrayDuplicate {
    /**
     * Метод remove убирает все дубликаты из строк массива.
     * @param array - входной массив типа String с дубликатами.
     * @return array без дубликатов.
     */
    public String[] remove(String[] array) {
        int dup = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - dup; j++) {
                if (array[i].equals(array[j])) {
                    while (j != array.length - dup - 1
                            && array[array.length - dup - 1].equals(array[j])) {
                        dup++;
                    }
                    String tmp = array[array.length - dup - 1];
                    array[array.length - dup - 1] = array[j];
                    array[j] = tmp;
                    dup++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - dup);
    }
}
