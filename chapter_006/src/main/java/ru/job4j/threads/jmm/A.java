package ru.job4j.threads.jmm;


class A {
    synchronized void foo (B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошёл в метод А.foo");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Класс А прерван");
        }
        System.out.println(name + " пытается вызвать метод В.last()");
        b.last();
    }
    synchronized void last() {
        System.out.println("B методе А.last()");
    }
}

class B {
    synchronized void bar (A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошёл в метод B.bar");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Класс B прерван");
        }
        System.out.println(name + " пытается вызвать метод A.last()");
        a.last();
    }
    synchronized void last() {
        System.out.println("B методе A.last()");
    }
}

class Deadlock implements Runnable {
    A a = new A();
    B b = new B();

    Deadlock() {
        Thread.currentThread().setName("Главный поток");
        Thread t = new Thread(this, "Соперничающий поток");
        t.start();

        b.bar(a);
        System.out.println("Назад в гланый поток");
    }

    @Override
    public void run() {
        a.foo(b);

        System.out.println("Назад в другой поток");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}