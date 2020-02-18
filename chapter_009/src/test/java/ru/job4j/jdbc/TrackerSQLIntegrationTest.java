package ru.job4j.jdbc;

import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
/**
 * Integration tests methods from TrackerSQL class.
 */
public class TrackerSQLIntegrationTest {

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void checkAddFunction() throws SQLException {
        Item mazda = new Item("Mazda", "Yellow");
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item expected = tracker.add(new Item("Mazda", "Yellow"));
            mazda.setId(tracker.findByName("Mazda").get(0).getId());
            assertEquals(expected, mazda);
        }
    }

    @Test
    public void checkReplaceFunction() throws SQLException {
        Item mitsubishi = new Item("Mitsubishi", "Green");
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Mazda", "Yellow"));
            boolean expected = tracker.replace(tracker.findByName("Mazda").get(0).getId(), mitsubishi);
            assertThat(expected, is(true));
        }
    }

    @Test
    public void checkDeleteFunction() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Mitsubishi", "Green"));
            boolean expected = tracker.delete(tracker.findByName("Mitsubishi").get(0).getId());
            assertThat(expected, is(true));
        }
    }

    @Test
    public void checkFindAllFunction() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Audi", "Black"));
            tracker.add(new Item("BMW", "White"));
            tracker.add(new Item("WW", "Red"));
            List<Item> expected = tracker.findAll();
            assertThat(expected.size(), is(3));
        }
    }

    @Test
    public void checkFindByIdFunction() throws SQLException {
        Item bmw = new Item("BMW", "White");
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(bmw);
            String id = tracker.findByName("BMW").get(0).getId();
            Item expected = tracker.findById(id);
            bmw.setId(id);
            assertEquals(expected, bmw);
        }
    }

    @Test
    public void checkFindByNameFunction() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Audi", "Black"));
            tracker.add(new Item("Audi", "White"));
            List<Item> expected = tracker.findByName("Audi");
            assertThat(expected.size(), is(2));
        }
    }
}
