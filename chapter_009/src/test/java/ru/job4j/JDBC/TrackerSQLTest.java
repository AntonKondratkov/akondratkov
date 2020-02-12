package ru.job4j.JDBC;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 04.02.2020
 * В данном классе осуществляется тестирование методов из класса TrackerSQL
 **/
public class TrackerSQLTest {

    private TrackerSQL trackerSQL = new TrackerSQL();

    List<Item> listOfCar = new ArrayList<>();

    Item audi;
    Item bmw;
    Item ww;

    @Before
    public void setUp() {
        trackerSQL = new TrackerSQL();
        audi = new Item("Audi", "Black");
        bmw = new Item("BMW", "White");
        ww = new Item("WW", "Red");
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
        Item mazda = new Item("Mazda", "Yellow");
        Item expected = trackerSQL.add(mazda);
        assertEquals(expected, mazda);
    }

    @Test
    public void checkReplaceFunction() {
        Item mitsubishi = new Item("Mitsubishi", "Green");
        List<Item> list = trackerSQL.findByName("Mazda");
        boolean expected = trackerSQL.replace(list.get(0).getId(), mitsubishi);
        assertThat(expected, is(true));
    }

    @Test
    public void checkDeleteFunction() {
        List<Item> list = trackerSQL.findByName("Mitsubishi");
        boolean expected = trackerSQL.delete(list.get(0).getId());
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
        String id = trackerSQL.findByName("BMW").get(0).getId();
        Item expected = trackerSQL.findById(id);
        bmw.setId(id);
        assertEquals(expected, bmw);
    }

    @Test
    public void checkFindByNameFunction() {
        List<Item> listByName = new ArrayList<>();
        List<Item> expected = trackerSQL.findByName("Audi");
        audi.setId(expected.get(0).getId());
        listByName.add(audi);
        assertEquals(expected, listByName);
    }
}
