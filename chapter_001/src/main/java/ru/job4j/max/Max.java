package ru.job4j.max;
/**
 *Class Max - решение задач в части 001 Базовый Синтаксис, урок 4 Условный оператор.
 *@author Anton Kondratkov
 *@since 13.11.2017
 */
public class Max {
     /**
     *Method max вычисляет максимум из двух чисел.
     *@return result.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

     /**
     *Method min вычисляет минимум из двух чисел.
     *@return result.
     */

    public int min(int first, int second) {
        return first < second ? first : second;
    }

    /**
     *Method maxOfThree вычисляет максимум из трёх чисел.
     *@return result.
     */

    public int maxOfThree(int first, int second, int third) {
        return max(max(first, second), third);
    }

    /**
     *Method minOfThree вычисляет минимум из трёх чисел.
     *@return result.
     */

    public int minOfThree(int first, int second, int third) {
        return min(min(first, second), third);
    }
}

