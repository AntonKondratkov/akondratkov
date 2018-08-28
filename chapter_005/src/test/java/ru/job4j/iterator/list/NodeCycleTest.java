package ru.job4j.iterator.list;

import org.junit.Test;
import ru.job4j.iterator.list.NodeCycle.Node;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 28.08.18.
 * Тестирование класса NodeCycle.
 **/
public class NodeCycleTest {
    /**
     * Один из элементов зациклен на себя и один элемент равен null.
     */
    @Test
    public void whenNodeEqualsNull() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = third;
        four.next = null;

        NodeCycle nodeCycle = new NodeCycle();

        assertThat(nodeCycle.hasCycle(first), is(true));
        assertThat(nodeCycle.hasCycle(two), is(true));
        assertThat(nodeCycle.hasCycle(third), is(true));
        assertThat(nodeCycle.hasCycle(four), is(false));
    }

    /**
     * Тест на цикличность списка.
     */
    @Test
    public void whenNodeNotEqualsNull() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        NodeCycle nodeCycle = new NodeCycle();

        assertThat(nodeCycle.hasCycle(first), is(true));
        assertThat(nodeCycle.hasCycle(two), is(true));
        assertThat(nodeCycle.hasCycle(third), is(true));
        assertThat(nodeCycle.hasCycle(four), is(true));
    }
}
