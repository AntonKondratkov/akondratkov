package ru.job4j.tracker;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @version $Id$
 * @since 0.inheritance
 * В данном классе осуществляется тестирование методов из класса Tracker.
 **/

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        // Добавляем заявку в трекер.
        tracker.add(item);
        // Проверяем, что заявка добавлена в 0 ячейку массива.
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере и проверяем, что метод возвращает "true".
        assertThat(tracker.replace(previous.getId(), next), is (true));
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(next.getId()).getName(), is(next.getName()));
    }

    @Test
    public void whenSpecifyIdReturnItem(){
        Tracker tracker = new Tracker();
        Item previous = new Item("test3", "testDescription3", 12345L);
        // Добавляем заявку в трекер.
        tracker.add(previous);
        Item next = new Item ("test4", "testDescription4", 12L);
        // Добавляем заявку в трекер.
        tracker.add(next);
        // Проверяем, что найденная заявка соответствует искомой по id заявке.
        assertThat(tracker.findById(previous.getId()), is(previous));
    }

    @Test
    public void whenSpecifyNameReturnItem(){
        Tracker tracker = new Tracker();
        Item previous = new Item("test5", "testDescription5", 12345L);
        // Добавляем заявку в трекер.
        tracker.add(previous);
        Item next = new Item ("test6", "testDescription6", 12L);
        // Добавляем заявку в трекер.
        tracker.add(next);
        // Проверяем, что найденная заявка соответствует искомой по имени заявке.
        assertThat(tracker.findByName("test6")[0], is(next));
    }

    @Test
    public void whenDeleteItemGetArrayWithoutThisItem(){
        Tracker tracker = new Tracker();
        Item previous = new Item("test7", "testDescription7", 12345L);
        // Добавляем заявку в трекер.
        tracker.add(previous);
        Item next = new Item ("test8", "testDescription8", 12L);
        // Добавляем заявку в трекер.
        tracker.add(next);
        Item next2 = new Item ("test88", "testDescription88", 12568L);
        // Добавляем заявку в трекер.
        tracker.add(next2);
        // Удаляем заявку "next" из массива и проверяем, что метод возвращает "true".
        assertThat(tracker.delete(previous.getId()), is(true));
        // Создаём массив для сравнения.
        Item[] item = {next, next2, null};
        // Проверяем, что массив "item" соответствует массиву,
        // который возвращает метод findAll() после удаления заявки "next".
        assertThat(tracker.findAll(), is(item));
    }

    @Test
    public void whenUsingFindAllTakeAllItems(){
        Tracker tracker = new Tracker();
        Item previous = new Item("test9", "testDescription9", 12345L);
        // Добавляем заявку в трекер.
        tracker.add(previous);
        Item next = new Item ("test10", "testDescription10", 12L);
        // Добавляем заявку в трекер.
        tracker.add(next);
        // Создаём массив для сравнения.
        Item[] item = {previous, next};
        // Проверяем, что массив "item" соответствует массиву который возвращает метод findAll().
        assertThat(tracker.findAll(), is(item));
    }
}