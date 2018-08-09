package ru.job4j.iterator.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * @author Anton Kondratkov
 * @since 09.08.18.
 * Тестирование класса RoleStore.
 **/
public class RoleStoreTest {
    private RoleStore store = new RoleStore(4);
    private Role role1 = new Role("1", "user1");
    private Role role2 = new Role("2", "user2");
    private Role role3 = new Role("3", "user3");
    private Role role4 = new Role("4", "user4");
    /**
     * Проверка метода add.
     */
    @Test
    public void whenAddObjects() {

        Object result = store.add(role1);

        assertThat(result, is(role1));
    }
    /**
     * Проверка метода delete.
     */
    @Test
    public void whenDeleteObject() {
        store.add(role1);
        store.add(role2);
        store.add(role3);
        store.add(role4);

        boolean result = store.delete(role2.getId());

        assertThat(result, is(true));
    }
    /**
     * Проверка метода FindById.
     */
    @Test
    public void whenObjectFindById() {
        store.add(role1);
        store.add(role2);
        store.add(role3);
        store.add(role4);

        Object result = store.findById(role1.getId());

        assertThat(result, is(role1));
    }
    /**
     * Проверка метода replace.
     */
    @Test
    public void whenObjectReplace() {
        store.add(role1);
        store.add(role2);
        store.add(role3);

        boolean result = store.replace(role2.getId(), role4);

        assertThat(result, is(true));
    }
}
