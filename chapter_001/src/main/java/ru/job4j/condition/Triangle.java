package ru.job4j.condition;

/**
 *Class Triangle - вычисляет площадь треуголника.
 *@author Anton Kondratkov
 *@since 11.11.2017
 */

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    private double rsl;


    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод distance вычисляет расстояние между точками left и right.
     */

    public double distance(Point left, Point right) {
        return Math.sqrt(Math.pow ((right.getX() - left.getX()), 2) + Math.pow ((right.getY() - left.getY()) , 2));
    }

    /**
     * Метод period вычисляет периметр по длинам сторон.
     */
    public double period(double ab, double ac, double bc) {

        return (ab+ac+bc)/2;
    }

    /**
     * Метод area вычисляет площадь треугольника.
     */

    public double area() {

        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p*(p-ab)*(p-ac)*(p-bc));

        }
        return rsl;
    }
    /**
     * Метод exist проверяет можно ли построить треугольник с заданными длинами сторон.
     */
    private boolean exist(double ab, double ac, double bc) {
        if ((ab + ac > bc) && (bc + ac > ab) && (bc + ab > ac)) {

        }
        return false;
    }
}