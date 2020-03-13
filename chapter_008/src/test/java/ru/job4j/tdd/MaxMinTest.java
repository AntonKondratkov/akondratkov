package ru.job4j.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Kondratkov Anton
 * @since 13.03.2020
 */
public class MaxMinTest {
    MaxMin maxMin;
    List<Integer> integerList;

    @Before
    public void before() {
        maxMin = new MaxMin();
        integerList = List.of(91, 81, 2, 543, 16, 754, 10);
    }

    @Test
    public void max() {
        int actual = maxMin.max(integerList, Integer::compareTo);
        assertThat(actual, is(754));
    }

    @Test
    public void min() {
        int actual = maxMin.min(integerList, Integer::compareTo);
        assertThat(actual, is(2));
    }
}