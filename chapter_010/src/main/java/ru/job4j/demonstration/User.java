package ru.job4j.demonstration;

public class User {
    public String name;
    public User(String name) {
        this.name = name;
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }
    @Override
    public String toString() {
        return "User{name=" + '\'' + name  + '\'' + '}';
    }
    public static void main(String[] args) {
        for (int i = 0; i < 13107; i++) {
            System.out.println(i);
            System.out.println(new User("Name"));
        }
    }
}
