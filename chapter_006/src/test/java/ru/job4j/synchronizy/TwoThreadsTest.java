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
 * @since 21.09.18.
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
        User user1 = new User(1, 1000);
        User user2 = new User(2, 800);
        User user3 = new User(3, 400);

        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);

        TwoThreads.Thread1 thread1 = new TwoThreads.Thread1(userStorage);
        thread1.t.join();


        User result = userStorage.getUser(1);
        int expect = 950;

        assertThat(result.getAmount(), is(expect));

        TwoThreads.Thread2 thread2 = new TwoThreads.Thread2(userStorage);
        thread2.t.join();

        User result2 = userStorage.getUser(1);
        int expect2 = 650;

        assertThat(result2.getAmount(), is(expect2));



    }
}
