package ru.job4j.departments;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDepartmentsSortedAsc() {
        List<String> list = Arrays.asList("K1/SK1", "K1/SK1/SSK1", "K1", "K1/SK2", "K1/SK1/SSK2",
                "K2/SK1", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2");
        List<String> expect = Arrays.asList("K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2",
                "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2");

        Departments.sortAsc(list);

        assertThat(list, is(expect));
    }

    @Test
    public void whenDepartmentsSortedDesc() {
        List<String> list = Arrays.asList("K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2",
                "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2");
        List<String> expect = Arrays.asList("K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2");

        Departments.sortDesc(list);

        assertThat(list, is(expect));
    }
}