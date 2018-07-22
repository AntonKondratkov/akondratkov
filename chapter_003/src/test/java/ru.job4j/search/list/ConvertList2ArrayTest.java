package ru.job4j.search.list;

import org.junit.Test;
import ru.job4j.list.ConvertList2Array;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 23.07.18.
 * Данный класс проверяет работу класса ConvertList2Array.
 */
public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                5
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0},
                {0, 0}


        };
        assertThat(result, is(expect));
    }
}
