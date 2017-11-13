package ru.job4j.condition;

/**
 *Class Point - описывает точку в системе координат.
 *@author Anton Kondratkov
 *@since 9.11.2017
 */

public class Point {
    private int x;
    private int y;
    private int a;
    private int b;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Method is определяет принадлежит ли точка графику функции.
     *
     * @return result.
     */
    public boolean is(int a, int b) {
        return this.y == this.x * a + b;
    }

}
