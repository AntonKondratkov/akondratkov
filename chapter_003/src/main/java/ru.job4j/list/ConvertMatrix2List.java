package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Anton Kondratkov
 * @since 24.07.18.
 * Класс содержит методы для:
 * 1. Конвертации двумерного массив в ArrayList.
 * 2. Конвертации листа с массивами типа int в лист содержащий элементы этих массивов.
 */
public class ConvertMatrix2List {
    /**
     * Метод конвертирует двумерный массив в ArrayList.
     * @param array - Двумерный массив.
     * @return - ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }

    /**
     * Метод конвертирует лист с массивами типа int в лист содержащий элементы этих массивов.
     * @param list - Лист с массивами типа int.
     * @return result - Лист с элементами массивов.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] value : list) {
            for (int value2 : value) {
                result.add(value2);
            }
        }
        return result;
    }
}
