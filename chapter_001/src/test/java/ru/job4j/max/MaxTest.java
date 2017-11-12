package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *@author Anton Kondratkov
 *@since 9.11.2017
 */

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        //assign block
        Max maxim = new Max();
        //act block
        int result = maxim.max(2,10);
        //assert block
        assertThat(result, is(10));

    }
    @Test
    public void whenSecondLessFirst() {
        //assign block
        Max minimum = new Max();
        //act block
        int result = minimum.min(10,2);
        //assert block
        assertThat(result, is(2));

    }
}