package ru.job4j.iterator.list;
/**
 * @author Anton Kondratkov
 * @since 28.08.18.
 * Определение цикличности связного списка.
 **/
public class NodeCycle {

    /**
     * Класс элементов списка.
     * @param <T> тип данных.
     */
    static class Node<T> {
        /**
         * Значение.
         */
        T value;
        /**
         * Ссылка на следующий элемент.
         */
        Node<T> next;

        /**
         * Конструктор.
         * @param value значение элемента.
         */
        Node(T value) {
            this.value = value;
        }
    }

    /**
     * Метод определяет цикличность в связном списке.
     * @param first начальный элемент.
     * @return true - список цикличный, false - список не цикличный.
     */
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
