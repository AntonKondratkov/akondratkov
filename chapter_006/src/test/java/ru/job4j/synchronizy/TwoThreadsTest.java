package ru.job4j.synchronizy;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.threads.synchronizy.TwoThreads;
import ru.job4j.threads.synchronizy.User;
import ru.job4j.threads.synchronizy.UserStorage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 12.11.18.
 * Тестирование класса TwoThreads.
 **/
public class TwoThreadsTest {
    private UserStorage userStorage;

    @Before
    public void start() {
        userStorage = new UserStorage();
    }

    @Test
    public void whenTransferAmount() throws InterruptedException {
        int amount = 100;

        User user1 = new User(0, 1000);
        User user2 = new User(1, 800);
        User user3 = new User(2, 400);

        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);

        TwoThreads threads1 = new TwoThreads(user3, user1, amount, userStorage);
        TwoThreads threads2 = new TwoThreads(user1, user2, amount, userStorage);

        threads1.start();
        threads1.join();

        User result = userStorage.getUser(0);
        int expect = 1100;

        assertThat(result.getAmount(), is(expect));

        threads2.start();
        threads2.join();


        User result2 = userStorage.getUser(0);
        int expect2 = 1000;

        assertThat(result2.getAmount(), is(expect2));
    }
}
