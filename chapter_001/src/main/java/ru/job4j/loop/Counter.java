package ru.job4j.loop;

/**
 *Class Counter - осуществляется подсчёт суммы чётных чисел в диапазоне.
 *@author Anton Kondratkov
 *@since 17.11.2017
 */

public class Counter{

    /**
     * Method add вычисляет сумму чётныx чисел в диапазоне от start до finish.
     *
     * @return result.
     */

    public int add(int start, int finish){

        int i;
        int summ=0;

        for (i = start; i <= finish; i++){

            if (i % 2 == 0){

                summ+=i;

            }

        }

        return summ;
    }
}
