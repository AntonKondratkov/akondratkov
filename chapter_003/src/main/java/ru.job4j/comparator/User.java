package ru.job4j.comparator;

/**
 * @author Anton Kondratkov
 * @since 27.07.18.
 * Класс создаёт объект "Пользователь" с полями: age и name.
 * В данном классе переопределяются методы: compareTo и toString.
 */
public class User implements Comparable<User> {
    private Integer age;
    private String name;
    private Integer size;

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
        this.size = name.length();
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "age: " + age + ", name " + name;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}