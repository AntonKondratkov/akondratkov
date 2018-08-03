package ru.job4j.iterator.generic;

public class SimpleArray<T> {

    private int index = 0;
    private Object[] objects;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add (T model) {
        arrayOut();
            this.objects[index++] = model;
    }

    public void set (int index, T model) {
        arrayOut();
        this.objects[index] = model;
    }

    public boolean delete(int index) {
        boolean result = false;
        if (index < this.index) {
            objects[index] = objects[this.index - 1];
            objects[this.index - 1] = null;
            result = true;
        }
        return result;
    }

    public T get(int index) {
        arrayOut();
        return (T)objects[index];
    }

    public void arrayOut() {
        if (index > objects.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
    }

}
