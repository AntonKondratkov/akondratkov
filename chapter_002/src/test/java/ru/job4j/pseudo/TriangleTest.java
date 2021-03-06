package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Kondratkov
 * @since 13.07.18.
 */
public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        assertThat(
                new Triangle().draw(),
                is(
                        new StringBuilder()
                                .append("  ^  ")
                                .append(System.lineSeparator())
                                .append(" ^ ^ ")
                                .append(System.lineSeparator())
                                .append("^^^^^")
                                .toString()
                ));
    }
}
