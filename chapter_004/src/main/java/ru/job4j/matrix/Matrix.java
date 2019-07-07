package ru.job4j.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *Class Matrix в данном классе происходит преобразование матрицы чисел в список чисел.
 *@author Anton Kondratkov
 *@since 07.07.2019
 */
public class Matrix {
    /**
     * Метод преобразует матрицу чисел в список чисел.
     * @param matrix Матрица чисел.
     * @return Список чисел.
     */
    public List<Integer> matrixIntoList(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
