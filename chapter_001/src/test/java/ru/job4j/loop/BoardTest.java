package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Class BoardTest в данном классе происходит тестирование класса Board.
 *@author Anton Kondratkov
 *@since 19.11.2017
 */

public class BoardTest{
    /**
     * Метод тестирует метод Board.paint() для шахматной доски размером 3х3.
     */
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows(){
        //создаём объект.
        Board board = new Board();
        //задаём размер шахматной доски.
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        // Задаем ожидаемый результат.
        String expected = String.format("X X%s X %sX X%s", line, line, line);
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }

    /**
     * Метод тестирует метод Board.paint() для шахматной доски размером 5х4.
     */

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows(){
        //создаём объект.
        Board board = new Board();
        //задаём размер шахматной доски.
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        // Задаем ожидаемый результат.
        String expected = String.format("X X X%s X X %sX X X%s X X %s", line, line, line, line);
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
}
