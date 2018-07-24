package ru.job4j.search.list;

import org.junit.Test;
import ru.job4j.list.ConvertMatrix2List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 24.07.18.
 * Данный класс проверяет работу класса ConvertMatrix2List.
 */

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4},
                {5, 6, 7}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenListSomeArrayToOneListIntiger() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        list.add(new int[]{7, 8});
        List<Integer> result = new ConvertMatrix2List().convert(list);
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8
        );
        assertThat(result, is(expect));

    }
}
