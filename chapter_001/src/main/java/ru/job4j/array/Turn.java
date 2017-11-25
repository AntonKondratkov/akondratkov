package ru.job4j.array;
/**
 *Class Turn - в данном классе происходит переворот массива.
 *@author Anton Kondratkov
 *@since 20.11.2017
 */
 class Turn {
    /**
     * Метод reverse переворачивает массив.
     * @param input - входной массив int
     * @return input в обратном порядке.
     */
    public int[] reverse(int[] input){
        for (int i = 0; i < input.length / 2; i++){
            int temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }
        return input;
    }
}