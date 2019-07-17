package ru.job4j.iterator.tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * В данном классе происходит проверка работы класса Tree.
 *@author Anton Kondratkov
 *@since 18.07.2019
 */
public class TreeTest {
    Tree<Integer> tree;
    @Before
    public void onStart() {
        tree = new Tree<>(1);
    }
    @Test
    public void when6ElFindLastThen6() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }
    @Test
    public void testIterator() {
        Integer expected = 1;

        for (Integer i : tree) {
            assertEquals(expected, i);
        }
    }
}
