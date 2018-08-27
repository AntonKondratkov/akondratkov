package ru.job4j.iterator.list;

public class NodeCycle {

    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    boolean hasCycle(Node first) {
        Node tortoise = first;
        Node hare = first.next;
        boolean result = false;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise.equals(hare)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
