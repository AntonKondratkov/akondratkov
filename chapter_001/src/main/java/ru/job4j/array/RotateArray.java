package ru.job4j.array;
/**
 *Class RotateArray - в данном классе происходит поворот квадратного массива на 90 градусов.
 *@author Anton Kondratkov
 *@since 25.11.2017
 */
public class RotateArray {
    /**
     * Метод rotate - поворачивает квадратный массив.
     * @param array - входной массив int
     * @return array повёрнутый на 90 градусов массив.
     */
    public int[][] rotate(int[][] array){
        int [][] retArr = new int[array[0].length][array.length];
        int retArrI = 0;
        int retArrJ = array.length - 1;
        for (int [] srI : array){
            for (int srJ : srI)
                retArr[retArrI++][retArrJ] = srJ;
            retArrI = 0;
            retArrJ--;
        }
        return retArr;

    }
}
