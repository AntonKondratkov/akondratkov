package ru.job4j.comparator;

import java.util.*;

/**
 * @author Anton Kondratkov
 * @since 27.07.18.
 * Класс прозводит сортировку объектов класса User.
 */
public class SortUser {
    /**
     * Метод сортирует пользователей по возрасту и
     * возвращает отсортированный список в виде TreeSet.
     * @param list Лист пользователей, который нужно отсортировать.
     * @return TreeSet
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }

    /**
     * Метод сортирует пользователей по длине имени.
     * @param list Лист пользователей, который нужно отсортировать.
     * @return result Отсортированный лист пользователей.
     */
    public List<User> sortNameLength(List<User> list) {
        List<User> result = list;
        result.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getSize().compareTo(o2.getSize());
                    }
                }
        );

        return result;
    }

    /**
     * Метод сортирует пользователей сначала в лексикографическом порядке,
     * затем по возрасту.
     * @param list Лист пользователей, который нужно отсортировать.
     * @return result Отсортированный лист пользователей.
     */
    public List<User> sortByAllFields(List<User> list) {
        List<User> result = list;
        result.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int age = o1.getName().compareTo(o2.getName());
                        if (age == 0) {
                           age = o1.getAge().compareTo(o2.getAge());
                        }
                        return age;
                    }
                }
        );
        return result;
    }
}
