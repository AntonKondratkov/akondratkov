package ru.job4j.start;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @version $Id$
 * @since 0.
 * В данном классе расположены JUnit тесты, использующие класс StubInput для эмуляции поведения пользователя.
 **/

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        //Создаём Tracker.
        Tracker tracker = new Tracker();
        //Создаём StubInput с последовательностью действий(производим добавление заявки).
        Input input = new StubInput(new String[] {"0", "first name", "first desc", "6"});
        //Создаём StartUI и вызываем метод init().
        new StartUI(input, tracker).init();
        //Проверяем, что нулевой элемент массива в трекере соедржит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("first name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue(){
        //Создаём Tracker.
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку.
        Item item = tracker.add(new Item("Test name", "desc"));
        //Создаём StubInput с последовательностью действий(производим замену заявки).
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        //Создаём StartUI и вызываем метод init().
        new StartUI(input, tracker).init();
        //Проверяем, что нулевой элемент массива в трекере соедржит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));

    }

    @Test
    public void whenUserDeleteItemRestMoveLeft(){
        //Создаём Tracker.
        Tracker tracker = new Tracker();
        //Напрямую добавляем две заявки.
        Item item3 = tracker.add(new Item("name3", "desc3"));
        Item item4 = tracker.add(new Item("name4", "desc4"));
        //Создаём StubInput с последовательностью действий(производим удаление заявки).
        Input input = new StubInput(new String[]{"3", item3.getId(),"6"});
        //Создаём StartUI и вызываем метод init().
        new StartUI(input, tracker).init();
        //Проверяем, что удалённый элемент отсутсвует и на его месте находится следующая заявка.
        assertThat(tracker.findAll()[0].getName(), is(item4.getName()));
    }
}
