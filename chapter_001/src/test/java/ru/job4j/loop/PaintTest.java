package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Class PaintTest в данном классе происходит тестирование класса Paint.
 *@author Anton Kondratkov
 *@since 19.11.2017
 */
public class PaintTest {
    /**
     * Метод тестирует метод Paint.piramid() для пирамиды высотой 2.
     */
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        //создаём объект.
        Paint paint = new Paint();
        //задаём высоту пирамиды.
        String result = paint.piramid(2);
        // Задаем ожидаемый результат.
        String expected = String.format(" ^%s^^^%<s", System.getProperty("line.separator"));
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
    /**
     * Метод тестирует метод Paint.piramid() для пирамиды высотой 3.
     */
    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        //создаём объект.
        Paint paint = new Paint();
        //задаём высоту пирамиды.
        String result = paint.piramid(3);
        // Задаем ожидаемый результат.
        String expected = String.format("  ^%s ^^^%<s^^^^^%<s", System.getProperty("line.separator"));
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
}