package ru.job4j.pseudo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.lineSeparator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Kondratkov
 * @since 12.07.18.
 */
public class PaintTest {
    @Test
    public void whenDrawSquare() {
        //Получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        //Создаём буфер для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в память тестирования.
        System.setOut(new PrintStream(out));
        //выполняем действия пишущее в консоль.
        new Paint().draw(new Square());
        //Проверяем результат вычисления.
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++\n")
                                .append("++++\n")
                                .append("++++\n")
                                .append("++++\n")
                                .append(lineSeparator())
                                .toString()
                )
        );
        //Возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        //Получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        //Создаём буфер для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в память тестирования.
        System.setOut(new PrintStream(out));
        //выполняем действия пишущее в консоль.
        new Paint().draw(new Triangle());
        //Проверяем результат вычисления.
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("  ^  \n")
                                .append(" ^ ^ \n")
                                .append("^^^^^\n")
                                .append(lineSeparator())
                                .toString()
                )
        );
        //Возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }
}
