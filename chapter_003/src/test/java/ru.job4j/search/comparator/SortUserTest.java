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
 * @since 26.07.18.
 * Класс тестирует работу класса SortUser.
 */
public class SortUserTest {
    @Test
    public void whenListSortElementToSet() {
        SortUser sortUser = new SortUser();
        List<User> result = new ArrayList<>();
        result.addAll(
                Arrays.asList(
                        new User(5, "e"),
                        new User(7, "b"),
                        new User(3, "a"),
                        new User(8, "c")
                )
        );
        Set<User> set = sortUser.sort(result);
        assertThat(set.iterator().next().getName(), is("a"));

    }
}
