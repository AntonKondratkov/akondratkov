package ru.job4j.synchronizy;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.threads.synchronizy.User;
import ru.job4j.threads.synchronizy.UserStorage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 18.09.18.
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
        User user1 = new User(1, 1000);
        User user2 = new User(2, 800);
        User user3 = new User(3, 400);

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
        User user1 = new User(1, 1000);
        User user2 = new User(2, 800);
        User user3 = new User(3, 400);

        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);

        User expect = new User(2, 700);
        userStorage.update(expect);

        assertThat(expect, is(userStorage.getUser(1)));
    }

    @Test
    public void whenDeleteUser() {
        User user1 = new User(1, 1000);
        User user2 = new User(2, 800);
        User user3 = new User(3, 400);

        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);

        userStorage.delete(user2);
        User expect = userStorage.getUser(1);

        assertThat(expect, is(user3));
    }

    @Test
    public void whenTransferAmount() throws InterruptedException {
        User user1 = new User(1, 1000);
        User user2 = new User(2, 800);
        User user3 = new User(3, 400);

        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);

        userStorage.transfer(1, 3, 400);
        User result = userStorage.getUser(2);
        int expect = 800;

        assertThat(result.getAmount(), is(expect));
    }
}
