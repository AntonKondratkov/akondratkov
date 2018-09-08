package ru.job4j.threads;

public class AsyncOperations {

    public static final class Calculate implements Runnable {
        public void run() {
            System.out.println("TODO async");
        }
    }

    public static void main(String[] args) {
        new Thread(new Calculate()).start();
        System.out.println("");
    }

}
