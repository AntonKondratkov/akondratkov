package ru.job4j.start;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Kondratkov
 * @since 12.07.18.
 * В данном классе расположены JUnit тесты, использующие класс StubInput для эмуляции поведения пользователя.
 **/

public class StartUITest {

    private final Tracker tracker = new Tracker();
    private final Item item = tracker.add(new Item("name5", "desc5"));

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
    @Test
    public void whenShowItems(){
        //Создаём StubInput с последовательностью действий(показать все заявки).
        Input input = new StubInput(new String[]{"1", "6"});
        //Создаём StartUI и вызываем метод init().
        new StartUI(input, tracker).init();
        //Проверяем, что найденные заявки соотвествуют тем, что добавили (item).
        Item[] expect  = {item};
        assertThat(tracker.findAll(), is(expect));
    }

    @Test
    public void whenFindId(){
        //Создаём StubInput с последовательностью действий(найти заявку по id).
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        //Создаём StartUI и вызываем метод init().
        new StartUI(input, tracker).init();
        //Проверяем, что найденная по id заявка соотвествуют добавленной (item).
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindName(){
        //Создаём StubInput с последовательностью действий(найти заявку по имени).
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        //Создаём StartUI и вызываем метод init().
        new StartUI(input, tracker).init();
        //Проверяем, что найденная по имени заявка соотвествуют добавленной (item).
        Item[] expect = {item};
        assertThat(tracker.findByName(item.getName()), is(expect));
    }
}
