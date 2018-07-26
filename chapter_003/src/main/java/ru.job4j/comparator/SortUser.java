package ru.job4j.comparator;

import java.util.*;

/**
 * @author Anton Kondratkov
 * @since 26.07.18.
 * Класс прозводит сортировку по возрасту в порядке возрастания.
 */
public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }
}
