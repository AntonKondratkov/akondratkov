package ru.job4j.list;

import java.util.List;
/**
 * @author Anton Kondratkov
 * @since 23.07.18.
 * Класс конвертирует ArrayList в двухмерный массив.
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int listIndex = 0;
        for (int rowIn = 0; rowIn < rows; rowIn++) {
            for (int cellIn = 0; cellIn < cells; cellIn++) {
                if (listIndex < list.size()) {
                    array[rowIn][cellIn] = list.get(listIndex++);
                } else {
                    array[rowIn][cellIn] = 0;
                }
            }
        }
        return array;
    }
}
