package ru.job4j.loop;

/**
 *Class Factorial - в данном классе происходит вычисление факториала.
 *@author Anton Kondratkov
 *@since 17.11.2017
 */

public class Factorial {

    /**
     * Method calc вычисляет факториал и возвращает рассчитанный факториал для этого числа.
     *
     * @return result.
     */

    public int calc(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

