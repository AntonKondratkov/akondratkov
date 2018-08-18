package ru.job4j.iterator.list;
/**
 * @author Anton Kondratkov
 * @since 19.08.18.
 * Контейнер типа Queue.
 **/
public class SimpleQueue<T> {
    // Хранилище.
    private Object[] container;
    //Размер списка.
    private int size = 3;
    //Позиция в массиве.
    private int position = 0;
    /**
     * Конструктор.
     */
    public SimpleQueue() {
        this.container = new Object[size];
    }
    /**
     * Метод возвращает элемент по индексу и явно приводит тип Object к типу T.
     * @param index индекс.
     * @return элемент типа Т.
     */
    T container(int index) {
        return (T) container[index];
    }
    /**
     * Метод возвращает первый элемент в очереди и удаляет его.
     * @return первый элемент в очереди.
     */
    public T poll() {
        int result = position;
        T obj;
        obj = container(result - position);
        removeElement(result - position);
        return obj;
    }
    /**
     * Метод добавляет элемент в очередь.
     * @param value добавляемый элемент.
     */
    public void push(T value) {
        container[position++] = value;
    }
    /**
     * Метод удаляет элемент из массива.
     * @param index индекс удаляемого элемента.
     */
    public void removeElement(int index) {
        if (index >= position) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int j = position - index - 1;
        if (j > 0) {
            System.arraycopy(container, index + 1, container, index, j);
        }
        position--;
        container[position] = null;
    }
}
