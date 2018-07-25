package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.strogare.Tracker;
import ru.job4j.tracker.input.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Kondratkov
 * @since 25.07.18.
 * В данном классе расположены JUnit тесты, использующие класс StubInput для эмуляции поведения пользователя.
 **/
public class StartUITest {
    //поле содержит объект класса Tracker
    private final Tracker tracker = new Tracker();
    //поле содержит объект класса Item
    private final Item item = tracker.add(new Item("name5", "desc5"));
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        //Создаём Tracker.
        Tracker tracker = new Tracker();
        //Создаём StubInput с последовательностью действий(производим добавление заявки).
        Input input = new StubInput(new String[] {"0", "first name", "first desc", "6"});
        //Создаём StartUI и вызываем метод init().
        new StartUI(input, tracker).init();
        //Проверяем, что нулевой элемент массива в трекере соедржит имя, введённое при эмуляции.
        assertThat(tracker.findAll().get(0).getName(), is("first name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
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
    public void whenUserDeleteItemRestMoveLeft() {
        //Создаём Tracker.
        Tracker tracker = new Tracker();
        //Напрямую добавляем две заявки.
        Item item3 = tracker.add(new Item("name3", "desc3"));
        Item item4 = tracker.add(new Item("name4", "desc4"));
        //Создаём StubInput с последовательностью действий(производим удаление заявки).
        Input input = new StubInput(new String[]{"3", item3.getId(), "6"});
        //Создаём StartUI и вызываем метод init().
        new StartUI(input, tracker).init();
        //Проверяем, что удалённый элемент отсутсвует и на его месте находится следующая заявка.
        assertThat(tracker.findAll().get(0).getName(), is(item4.getName()));
    }

    @Test
    public void whenShowItems() {
        new StartUI(new StubInput(new String[]{"1", "6"}), tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Select from 0 to 6")
                                .append(System.lineSeparator())
                                .append("0. Add the new item.")
                                .append(System.lineSeparator())
                                .append("1. Show the all items.")
                                .append(System.lineSeparator())
                                .append("2. Edit the new item.")
                                .append(System.lineSeparator())
                                .append("3. Delete the item.")
                                .append(System.lineSeparator())
                                .append("4. Find the item by id.")
                                .append(System.lineSeparator())
                                .append("5. Find the item by name.")
                                .append(System.lineSeparator())
                                .append("6. Exit programm.")
                                .append(System.lineSeparator())
                                .append(String.format("%s. %s", item.getId(), item.getName()))
                                .append(System.lineSeparator())
                                .append("Select from 0 to 6")
                                .append(System.lineSeparator())
                                .append("0. Add the new item.")
                                .append(System.lineSeparator())
                                .append("1. Show the all items.")
                                .append(System.lineSeparator())
                                .append("2. Edit the new item.")
                                .append(System.lineSeparator())
                                .append("3. Delete the item.")
                                .append(System.lineSeparator())
                                .append("4. Find the item by id.")
                                .append(System.lineSeparator())
                                .append("5. Find the item by name.")
                                .append(System.lineSeparator())
                                .append("6. Exit programm.")
                                .append(System.lineSeparator())
                                .append("Menu item selected \"Exit programm.\"")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindId() {
        new StartUI(new StubInput(new String[]{"4", item.getId(), "6"}), tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Select from 0 to 6")
                                .append(System.lineSeparator())
                                .append("0. Add the new item.")
                                .append(System.lineSeparator())
                                .append("1. Show the all items.")
                                .append(System.lineSeparator())
                                .append("2. Edit the new item.")
                                .append(System.lineSeparator())
                                .append("3. Delete the item.")
                                .append(System.lineSeparator())
                                .append("4. Find the item by id.")
                                .append(System.lineSeparator())
                                .append("5. Find the item by name.")
                                .append(System.lineSeparator())
                                .append("6. Exit programm.")
                                .append(System.lineSeparator())
                                .append(String.format("%s. %s", item.getId(), item.getName()))
                                .append(System.lineSeparator())
                                .append("Select from 0 to 6")
                                .append(System.lineSeparator())
                                .append("0. Add the new item.")
                                .append(System.lineSeparator())
                                .append("1. Show the all items.")
                                .append(System.lineSeparator())
                                .append("2. Edit the new item.")
                                .append(System.lineSeparator())
                                .append("3. Delete the item.")
                                .append(System.lineSeparator())
                                .append("4. Find the item by id.")
                                .append(System.lineSeparator())
                                .append("5. Find the item by name.")
                                .append(System.lineSeparator())
                                .append("6. Exit programm.")
                                .append(System.lineSeparator())
                                .append("Menu item selected \"Exit programm.\"")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindName() {
        new StartUI(new StubInput(new String[]{"5", "name5", "6"}), tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Select from 0 to 6")
                                .append(System.lineSeparator())
                                .append("0. Add the new item.")
                                .append(System.lineSeparator())
                                .append("1. Show the all items.")
                                .append(System.lineSeparator())
                                .append("2. Edit the new item.")
                                .append(System.lineSeparator())
                                .append("3. Delete the item.")
                                .append(System.lineSeparator())
                                .append("4. Find the item by id.")
                                .append(System.lineSeparator())
                                .append("5. Find the item by name.")
                                .append(System.lineSeparator())
                                .append("6. Exit programm.")
                                .append(System.lineSeparator())
                                .append(String.format("%s. %s", item.getId(), item.getName()))
                                .append(System.lineSeparator())
                                .append("Select from 0 to 6")
                                .append(System.lineSeparator())
                                .append("0. Add the new item.")
                                .append(System.lineSeparator())
                                .append("1. Show the all items.")
                                .append(System.lineSeparator())
                                .append("2. Edit the new item.")
                                .append(System.lineSeparator())
                                .append("3. Delete the item.")
                                .append(System.lineSeparator())
                                .append("4. Find the item by id.")
                                .append(System.lineSeparator())
                                .append("5. Find the item by name.")
                                .append(System.lineSeparator())
                                .append("6. Exit programm.")
                                .append(System.lineSeparator())
                                .append("Menu item selected \"Exit programm.\"")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
