package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
/**
 *Class Mathematics в данном классе производится подсчёт функции в диапазоне.
 *@author Anton Kondratkov
 *@since 01.07.2019
 */
public class Mathematics {
    /**
     * Метод реализует подсчёт функции в диапазоне.
     * @param start - Начальное значение диапазона.
     * @param end - Конечное значение диапазона.
     * @param function - Функциональный интерфейс Function.
     * @return - Лист с посчитанными значениями.
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> function) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index != end; index++) {
            result.add(function.apply((double) index));
        }
        return result;
    }
}
