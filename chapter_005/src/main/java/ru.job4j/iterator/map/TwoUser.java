package ru.job4j.iterator.map;

import java.util.HashMap;
import java.util.Map;
/**
 * Класс содержит два объекта имеющих одинаковые поля.
 */
public class TwoUser {
    static User first = new User("Ivan", 1);
    static User second = new User("Ivan", 1);

    static Map<User, Object> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(first, "first");
        map.put(second, "first");

        System.out.println(map);
    }
}
