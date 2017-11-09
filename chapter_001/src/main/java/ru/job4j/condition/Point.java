package ru.job4j.condition;

/**
 *Class Point - описывает точку в системе координат.
 *@author Anton Kondratkov
 *@since 9.11.2017
 */

public class Point {
    private int x;
    private int y;

    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     *Method is определяет принадлежит ли точка графику функции.
     *@return result.
     */
    public boolean is(int a, int b) {
        if (y ==  a * x + b) {
            return true;
        } else {
            return false;
        }
    }
}
