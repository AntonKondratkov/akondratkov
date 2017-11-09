package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *@author Anton Kondratkov
 *@since 4.11.2017
 */
public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        //act block
        calc.add(1D, 1D);
        //assign block
        double result = calc.getResult();
        double expected = 2D;
        //assert block
        assertThat(result, is(expected));
    }
    @Test
    public void whenMultiplyTwoMultiplyTwoThenFour() {
        Calculator calc = new Calculator();
        //act block
        calc.multiple(2D, 2D);
        //assign block
        double result = calc.getResult();
        double expected = 4D;
        //assert block
        assertThat(result, is(expected));
    }
    @Test
    public void whenSubThreeMinusTwoThenOne() {
        Calculator calc = new Calculator();
        //act block
        calc.sub(3D, 2D);
        //assign block
        double result = calc.getResult();
        double expected = 1D;
        //assert block
        assertThat(result, is(expected));
    }
    @Test
    public void whenDivSixDivTwoThenThree() {
        Calculator calc = new Calculator();
        //act block
        calc.div(6D, 2D);
        //assign block
        double result = calc.getResult();
        double expected = 3D;
        //assert block
        assertThat(result, is(expected));
    }
}