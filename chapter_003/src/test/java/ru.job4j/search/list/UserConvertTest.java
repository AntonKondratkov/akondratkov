package ru.job4j.search.list;

import org.junit.Test;
import ru.job4j.list.User;
import ru.job4j.list.UserConvert;
import java.util.ArrayList;
import java.util.HashMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Kondratkov
 * @since 25.07.18.
 * Данный класс проверяет работу класса UserConvert.
 */
public class UserConvertTest {
    @Test
    public void whenConvertListToMap() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "name1", "City1"));
        users.add(new User(2, "name2", "City2"));
        HashMap<Integer, User> result = new UserConvert().process(users);
        assertThat(result.get(1).getName(), is("name1"));
    }
}
