package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Anton Kondratkov
 * @since 23.07.18.
 * Класс конвертирует двумерный массив в ArrayList.
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}
