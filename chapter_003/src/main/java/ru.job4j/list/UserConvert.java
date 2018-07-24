package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * @author Anton Kondratkov
 * @since 25.07.18.
 * Класс конвертирует лист со списком пользователей в Map с ключом Integer id и соответствующим ему User.
 */
public class UserConvert {
    /**
     * Метод конвертирует List в Map.
     * @param list Лист с пользователями.
     * @return Map с пользователями.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> people = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            people.put(list.get(i).getId(), list.get(i));
        }
        return people;
    }
}

