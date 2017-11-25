package ru.job4j.calculator;

/**
 *Class Calculator класс для вычисления арифметических операций +, *,, / соответственно.
 *@author Anton Kondratkov
 *@since 4.11.2017
 */

public class Calculator {

    private double result;

    /**
     *Метод add операция сложение.
     *@param first первый аргумент.
     *@param second второй аргумент.
     *return результат.
     */

    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     *Метод multiple операция умножение.
     *@param first первый аргумент.
     *@param second второй аргумент.
     *return результат.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     *Метод sub операция вычитание.
     *@param first первый аргумент.
     *@param second второй аргумент.
     *return результат.
     */
    public void sub(double first, double second) {
        this.result = first-second;
    }
    /**
     *Метод div операция деление.
     *@param first первый аргумент.
     *@param second второй аргумент.
     *return результат.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     *Метод getResult метод возвращает значение поля result.
     *return результат.
     */
    public double getResult() {
        return this.result;
    }

}