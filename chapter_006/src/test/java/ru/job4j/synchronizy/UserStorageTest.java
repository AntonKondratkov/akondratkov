package ru.job4j.synchronizy;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.threads.synchronizy.User;
import ru.job4j.threads.synchronizy.UserStorage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 12.11.18.
 * Тестирование методов класса UserStorage.
 **/
public class UserStorageTest {
    private UserStorage userStorage;

    @Before
    public void start() {
        userStorage = new UserStorage();
    }

    @Test
    public void whenAddUser() {
        User user1 = new User(0, 1000);
        User user2 = new User(1, 800);
        User user3 = new User(2, 400);

        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);

        User result1 = userStorage.getUser(0);
        User result2 = userStorage.getUser(1);
        User result3 = userStorage.getUser(2);

        assertThat(result1, is(user1));
        assertThat(result2, is(user2));
        assertThat(result3, is(user3));
    }

    @Test
    public void whenUpdateUser() {
        User user1 = new User(0, 1000);
        User user2 = new User(1, 800);
        User user3 = new User(2, 400);

        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);

        User expect = new User(2, 700);
        userStorage.update(expect);

        assertThat(expect, is(userStorage.getUser(2)));
    }

    @Test
    public void whenDeleteUser() {
        User user1 = new User(0, 1000);
        User user2 = new User(1, 800);
        User user3 = new User(2, 400);

        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);

        userStorage.delete(user1);
        User expect = userStorage.getUser(0);

        assertThat(expect, is(user2));
    }

    @Test
    public void whenTransferAmount() throws InterruptedException {
        User user1 = new User(0, 1000);
        User user2 = new User(1, 800);
        User user3 = new User(2, 400);

        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);

        userStorage.transfer(0, 2, 400);
        User result0 = userStorage.getUser(0);
        User result2 = userStorage.getUser(2);
        int expect0 = 600;
        int expect2 = 800;

        assertThat(result0.getAmount(), is(expect0));
        assertThat(result2.getAmount(), is(expect2));

        boolean result = userStorage.transfer(2, 1, 5000);
        assertThat(result, is(false));

    }
}
