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
 * @since 27.07.18.
 * Класс тестирует работу класса SortUser.
 */
public class SortUserTest {
    @Test
    public void whenListSortElementToSet() {
        SortUser sortUser = new SortUser();
        List<User> result = new ArrayList<>();
        result.addAll(
                Arrays.asList(
                        new User(5, "Tom"),
                        new User(7, "Ivan"),
                        new User(3, "Tom"),
                        new User(8, "Anton")
                )
        );
        Set<User> set = sortUser.sort(result);
        assertThat(set.iterator().next().getName(), is("Tom"));

    }
    @Test
    public void whenListSortElementByNameLength() {
        SortUser sortUser = new SortUser();
        List<User> result = new ArrayList<>();
        result.addAll(
                Arrays.asList(
                        new User(5, "Tom"),
                        new User(7, "Ivan"),
                        new User(3, "Tom"),
                        new User(8, "Anton")
                )
        );
        List<User> list = sortUser.sortNameLength(result);
        assertThat(list.get(0).getName(), is("Tom"));
        assertThat(list.get(3).getName(), is("Anton"));

    }
    @Test
    public void whenListSortElementByAllFields() {
        SortUser sortUser = new SortUser();
        List<User> result = new ArrayList<>();
        result.addAll(
                Arrays.asList(
                        new User(5, "Tom"),
                        new User(7, "Ivan"),
                        new User(3, "Tom"),
                        new User(8, "Anton")
                )
        );
        List<User> list = sortUser.sortByAllFields(result);
        assertThat(list.get(0).getName(), is("Anton"));
        assertThat(list.get(3).getAge(), is(5));

    }
}
