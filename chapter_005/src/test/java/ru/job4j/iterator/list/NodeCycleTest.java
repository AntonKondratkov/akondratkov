package ru.job4j.iterator.list;

import org.junit.Test;
import ru.job4j.iterator.list.NodeCycle.Node;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NodeCycleTest {
    @Test
    public void whenNodeEqualsNull() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;

        NodeCycle nodeCycle = new NodeCycle();

        assertThat(nodeCycle.hasCycle(first), is(false));
        assertThat(nodeCycle.hasCycle(two), is(false));
        assertThat(nodeCycle.hasCycle(third), is(false));
        assertThat(nodeCycle.hasCycle(four), is(false));
    }
}
