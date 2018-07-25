package ru.job4j.comparator;

/**
 * @author Anton Kondratkov
 * @since 26.07.18.
 * Класс создаёт объект "Пользователь" с полями: age и name.
 * В данном классе переопределяются методы: compareTo и toString.
 */
public class User implements Comparable {
    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        User entry = (User) o;
        int result = age - entry.age;
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return result;
    }

    @Override
    public String toString() {
        return "age: " + age + ", name " + name;
    }
}