package ru.job4j.iterator.list;
/**
 * @author Anton Kondratkov
 * @since 25.08.18.
 * Контейнер типа Queue.
 **/
public class SimpleQueue<e> {
    private AsLinkedList<e> linkedList = new AsLinkedList<>();
    /**
     * Метод возвращает первый элемент в очереди и удаляет его.
     * @return первый элемент в очереди.
     */
    public e poll() {
        return linkedList.removeFirst();
    }
    /**
     * Метод добавляет элемент в очередь.
     * @param value добавляемый элемент.
     */
    public void push(e value) {
        linkedList.addLast(value);
    }
}
