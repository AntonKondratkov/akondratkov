package ru.job4j.search.comparator;

import org.junit.Test;
import ru.job4j.comparator.SortUser;
import ru.job4j.comparator.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Kondratkov
 * @since 09.07.19.
 * Класс тестирует работу класса SortUser.
 */
public class SortUserTest {
    //Поле содержит объект класса SortUser.
    SortUser sortUser = new SortUser();
    //Список пользователей.
    List<User> listOfUser = new ArrayList<>(List.of(
            new User(5, "Tom"),
            new User(7, "Ivan"),
            new User(3, "Tom"),
            new User(8, "Anton")
    ));
    /**
     * Тестирование метода sort.
     * Метод sort сортирует пользователей по возрасту и
     * возвращает отсортированный список в виде TreeSet.
     */
    @Test
    public void whenListSortElementToSet() {
        Set<User> result = sortUser.sort(listOfUser);
        Set<User> expected = Set.of(
                new User(5, "Tom"),
                new User(7, "Ivan"),
                new User(3, "Tom"),
                new User(8, "Anton")
        );
        assertThat(result, is(expected));
    }
    /**
     * Тестирование метода sortNameLength.
     * Метод сортирует пользователей по длине имени.
     */
    @Test
    public void whenListSortElementByNameLength() {
        List<User> expected = List.of(
                listOfUser.get(0),
                listOfUser.get(2),
                listOfUser.get(1),
                listOfUser.get(3)
        );
        List<User> result = sortUser.sortNameLength(listOfUser);
        assertThat(result, is(expected));

    }
    /**
     * Тестирование метода sortByAllFields
     * Метод сортирует пользователей сначала в лексикографическом порядке,
     * затем по возрасту.
     */
    @Test
    public void whenListSortElementByAllFields() {
        List<User> expected = List.of(
                listOfUser.get(3),
                listOfUser.get(1),
                listOfUser.get(2),
                listOfUser.get(0)
        );
        List<User> result = sortUser.sortByAllFields(listOfUser);
        assertThat(result, is(expected));
    }
}
