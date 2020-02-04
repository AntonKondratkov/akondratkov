package ru.job4j.JDBC;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * @author Anton Kondratkov
 * @since 04.02.2020
 * В данном классе осуществляется тестирование методов из класса TrackerSQL
 **/
public class TrackerSQLTest {

    private TrackerSQL trackerSQL;
    List<Item> listOfCar = new ArrayList<>();
    Item audi;
    Item bmw;
    Item ww;

    @Before
    public void setUp() {
        trackerSQL = new TrackerSQL();
        audi = new Item("Audi", "Black", "1");
        bmw = new Item("BMW", "White", "3");
        ww = new Item("WW", "Red", "7");
        listOfCar.add(audi);
        listOfCar.add(bmw);
        listOfCar.add(ww);
    }

    @Test
    public void checkConnection() {
        assertThat(trackerSQL.init(), is(true));
    }

    @Test
    public void checkAddFunction() {
        Item mazda = new Item("Mazda", "Yellow", "2");
        Item expected = trackerSQL.add(mazda);
        assertEquals(expected, mazda);
    }

    @Test
    public void checkReplaceFunction() {
        Item mitsubishi = new Item("Mitsubishi", "Green", "5");
        boolean expected = trackerSQL.replace("2", mitsubishi);
        assertThat(expected, is(true));
    }

    @Test
    public void checkDeleteFunction() {
        boolean expected = trackerSQL.delete("7");
        assertThat(expected, is(true));
    }

    @Test
    public void checkFindAllFunction() {
        trackerSQL.add(audi);
        trackerSQL.add(bmw);
        trackerSQL.add(ww);
        List<Item> expected = trackerSQL.findAll();
        assertEquals(expected, listOfCar);
    }

    @Test
    public void checkFindByIdFunction() {
        Item expected = trackerSQL.findById("3");
        assertEquals(expected, bmw);
    }

    @Test
    public void checkFindByNameFunction() {
        List<Item> listByName = new ArrayList<>();
        listByName.add(audi);
        List<Item> expected = trackerSQL.findByName("Audi");
        assertEquals(expected, listByName);
    }
}
