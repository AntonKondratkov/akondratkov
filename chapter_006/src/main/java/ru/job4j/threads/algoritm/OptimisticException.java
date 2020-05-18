package ru.job4j.threads.algoritm;

public class OptimisticException extends RuntimeException {
    public OptimisticException(String name) {
        print(name);
    }
    public void print(String name) {
        System.out.println("Data in the stream ".concat(name).concat(" was not changed"));
    }
}
