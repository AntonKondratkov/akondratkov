package ru.job4j.array;
/**
 *Class BubbleSort - в данном классе происходит сортировка массива.
 *@author Anton Kondratkov
 *@since 25.11.2017
 */

public class BubbleSort {
    /**
     * Метод sort сортирует массив.
     * @param array - входной массив int
     * @return array в отсортированном порядке.
     */

    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
