package ru.job4j.JDBC;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.strogare.ITracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/**
 * @author Anton Kondratkov
 * @since 04.02.2020
 * Переделанный класс Tracker из модуля chapter_002 для работы с БД PostgreSQL
 **/
public class TrackerSQL implements ITracker {

    private static final Logger Log = LogManager.getLogger(TrackerSQL.class.getName());

    private Connection connection;

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    @Override
    public Item add(Item item) {
        init();
        try (PreparedStatement st = connection.prepareStatement("insert into car (id, name, color) values (?, ?, ?)")) {
            st.setString(1, item.getId());
            st.setString(2, item.name);
            st.setString(3, item.description);
            st.executeUpdate();
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return  findById(item.getId());
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        Item item_result;
        init();
        try (PreparedStatement st = connection.prepareStatement("update car set id=?, name=?, color=? where id = ?")) {
            st.setString(1, item.getId());
            st.setString(2, item.name);
            st.setString(3, item.description);
            st.setString(4, id);
            st.executeUpdate();
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        item_result = findById(item.getId());
        if (item_result.getId().equals(item.getId())) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        init();
        if (findById(id) == null){
            System.out.println("Item not found");
        } else {
            try (PreparedStatement st = connection.prepareStatement("delete from car where id = ?")) {
                st.setString(1, id);
                st.executeUpdate();
            } catch (Exception e) {
                Log.error(e.getMessage(), e);
            }
            if (findById(id) == null) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        init();
        List<Item> list = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement("SELECT * FROM car")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Item(rs.getString("name"),
                        rs.getString("color"),
                        rs.getString("id")));
            }
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        init();
        List<Item> list = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement("SELECT * FROM car as c WHERE c.name IN (?)")) {
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Item(rs.getString("name"),
                        rs.getString("color"),
                        rs.getString("id")));
            }
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return list;
    }

    @Override
    public Item findById(String id) {
        init();
        Item item = null;
        try (PreparedStatement st = connection.prepareStatement("SELECT * FROM car as c WHERE c.id IN (?)")) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                item = new Item(rs.getString("name"),
                        rs.getString("color"),
                        rs.getString("id"));
            }
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return item;
    }
}
