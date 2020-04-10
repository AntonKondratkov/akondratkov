package ru.job4j.sort;

import java.util.Arrays;
/**
 * @author Anton Kondratkov
 * @since 10.04.20.
 * Класс реализует механизм возврата монет в лендинговых аппаратах.
 */
public class Machine {
    /**
     * Массив монет, которыми возвращается сдача с покупки.
     */
    private final int[] coins = {10, 5, 2, 1};
    /**
     * Метод реализует механизм возврата сдачи в лендинговых аппаратах.
     * @param money Купюра на которую производится покупка.
     * @param price Сумма покупки.
     * @return int[] Сдача.
     */
    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int result = money - price;
        int size = 0;
        for (int i = 0; i < coins.length; i++) {
            while (result - coins[i] >= 0) {
                rsl[size++] = coins[i];
                result = result - coins[i];
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
