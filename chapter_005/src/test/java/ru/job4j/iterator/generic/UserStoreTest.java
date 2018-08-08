package ru.job4j.iterator.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * @author Anton Kondratkov
 * @since 09.08.18.
 * Тестирование класса UserStore.
 **/
public class UserStoreTest {

    UserStore store = new UserStore(4);
    private User user1 = new User("1", "user1");
    private User user2 = new User("2", "user2");
    private User user3 = new User("3", "user3");
    private User user4 = new User("4", "user4");
    /**
     * Проверка метода add.
     */
    @Test
    public void whenAddObjects() {

        Object result = store.add(user4);

        assertThat(result, is(user4));
    }
    /**
     * Проверка метода delete.
     */
    @Test
    public void whenDeleteObject() {
        store.add(user1);
        store.add(user2);
        store.add(user3);
        store.add(user4);

        boolean result = store.delete(user2.getId());

        assertThat(result, is(true));
    }
    /**
     * Проверка метода FindById.
     */
    @Test
    public void whenObjectFindById() {
        store.add(user1);
        store.add(user2);
        store.add(user3);
        store.add(user4);

        Object result = store.findById(user1.getId());

        assertThat(result, is(user1));
    }
    /**
     * Проверка метода replace.
     */
    @Test
    public void whenObjectReplace() {
        store.add(user1);
        store.add(user2);
        store.add(user3);
        store.add(user4);

        boolean result = store.replace(user2.getId(), user4);

        assertThat(result, is(true));
    }
}
