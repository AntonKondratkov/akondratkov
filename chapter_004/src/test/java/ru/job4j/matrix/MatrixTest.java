package ru.job4j.matrix;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 *Class MatrixTest в данном классе тестируется класс Matrix.
 *@author Anton Kondratkov
 *@since 07.07.2019
 */
public class MatrixTest {
    //Поле содержит объект класса Matrix
    Matrix matrix = new Matrix();
    //Матрица чисел
    Integer[][] integers = {{1, 2, 3}, {5, 6, 7, 4}, {9, 12, 16, 34}};
    /**
     * Метод сравнивает список чисел, который возвращает метод matrixIntoList с ожидаемым списком
     */
    @Test
    public void whenMatrixConvertToList() {
        List<Integer> result = matrix.matrixIntoList(integers);
        List<Integer> expected = Arrays.asList(
                1, 2, 3, 5, 6, 7, 4, 9, 12, 16, 34
        );
        assertThat(result, is(expected));
    }
}
