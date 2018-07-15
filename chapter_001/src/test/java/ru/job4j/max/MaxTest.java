package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *@author Anton Kondratkov
 *@since 13.11.2017
 */

public class MaxTest {
    @Test
    public void whenFirstOnSecond() {
        //assign block
        Max maxim = new Max();
        //act block
        int result = maxim.max(2, 10);
        //assert block
        assertThat(result, is(10));

    }
    @Test
    public void whenSecondLessFirst() {
        //assign block
        Max minimum = new Max();
        //act block
        int result = minimum.min(9, 3);
        //assert block
        assertThat(result, is(3));

    }
    @Test
    public void whenFirstOnSecondOrThird() {
        //assign block
        Max maximThree = new Max();
        //act block
        int result = maximThree.maxOfThree(4, 13, 8);
        //assert block
        assertThat(result, is(13));
    }
    @Test
    public void whenFirstLessSecondOrThird() {
        //assign block
        Max minimumThree = new Max();
        //act block
        int result = minimumThree.minOfThree(25, 11, 7);
        //assert block
        assertThat(result, is(7));
    }
}