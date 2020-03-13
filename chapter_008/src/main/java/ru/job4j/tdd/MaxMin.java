package ru.job4j.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
/**
 * @author Anton Kondratkov
 * @since 13.03.20.
 * Класс реализует поиск минимального и максимального значения в списке по критерию java.util.Comparator.
 */
public class MaxMin {
    /**
     * Метод реализует алгоритм поиска элемента по заданному условию с помощью BiPredicate
     * @param value список элементов
     * @param biPredicate предикат с двумя параметрами, которые нужно сравнить
     * @return искомое значение
     */
    public Integer maxMin(List<Integer> value, BiPredicate<Integer, Integer> biPredicate) {
        Integer result = value.get(0);
        for (Integer val: value) {
            if (biPredicate.test(result, val)) {
                result = val;
            }
        }
        return result;
    }
    /**
     * Метод ищет максимальный элемент в спике.
     * @param value список элементов
     * @param comparator компаратор
     * @return максимальный элемент
     */
    public Integer max(List<Integer> value, Comparator<Integer> comparator) {
        return maxMin(value, (x, y) -> comparator.compare(x, y) < 0);
    }
    /**
     * Метод ищет минимальный элемент в спике.
     * @param value список элементов
     * @param comparator компаратор
     * @return минимальный элемент
     */
    public Integer min(List<Integer> value, Comparator<Integer> comparator) {
        return maxMin(value, (x, y) -> comparator.compare(x, y) > 0);
    }
}
