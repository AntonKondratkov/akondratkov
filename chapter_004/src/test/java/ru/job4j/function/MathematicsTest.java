package ru.job4j.function;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 *Class MathematicsTest в данном классе производится тестирование класса Mathematics.
 *@author Anton Kondratkov
 *@since 01.07.2019
 */
public class MathematicsTest {
    /**
     * Метод считает линейную функцию.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Mathematics mathematics = new Mathematics();
        List<Double> result = mathematics.diapason(5, 8, x -> (double) 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    /**
     * Метод считает квадратичную функцию.
     */
    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        Mathematics mathematics = new Mathematics();
        List<Double> result = mathematics.diapason(5, 8, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }
    /**
     * Метод считает логарифмическую функцию.
     */
    @Test
    public void whenLogarithmicFunctionThenLinearResults() {
        Mathematics mathematics = new Mathematics();
        List<Double> result = mathematics.diapason(5, 8, x -> Math.log(x));
        List<Double> expected = Arrays.asList(1.6094379124341003, 1.791759469228055, 1.9459101490553132);
        assertThat(result, is(expected));
    }
}
