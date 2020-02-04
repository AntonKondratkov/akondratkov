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
 * Переделанный класс Tracker из модуля chapter_002 для работы с БД PostgreSQL.
 **/
public class TrackerSQL implements ITracker {

    private static final Logger Log = LogManager.getLogger(TrackerSQL.class.getName());

    private Connection connection;

    public TrackerSQL() {
        init();
    }
    /*
     * Метод устанавливает соединение с БД.
     * @return true если соединение установлено и false если не установлено.
     */
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
    /*
     * Метод производит добавление заявки в БД
     * @return возвращает добавленный объект класса Item
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement st = connection.prepareStatement("insert into car (id, name, color) values (?, ?, ?)")) {
            st.setString(1, item.getId());
            st.setString(2, item.name);
            st.setString(3, item.description);
            st.executeUpdate();
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return item;
    }
    /*
     * Метод производит поиск заявки в БД по id и заменяет найденную заявку на передаваемую в параметрах
     * @param id - id заменяемой заявки
     * @param item - заявка на которую необходимо заменить найденную
     * @return true если заявка добавлена и false если не добавлена
     */
    @Override
    public boolean replace(String id, Item item) {
        int result = 0;
        try (PreparedStatement st = connection.prepareStatement("update car set id=?, name=?, color=? where id = ?")) {
            st.setString(1, item.getId());
            st.setString(2, item.name);
            st.setString(3, item.description);
            st.setString(4, id);
            result = st.executeUpdate();
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return result == 1;
    }
    /*
     * Метод производит удаление заявки из БД
     * @param id - id удаляемой заявки
     * @return true если заявка удалена и false если не удалена.
     */
    @Override
    public boolean delete(String id) {
        int result = 0;
        try (PreparedStatement st = connection.prepareStatement("delete from car where id = ?")) {
            st.setString(1, id);
            result = st.executeUpdate();
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return result == 1;
    }
    /*
     * Метод возвращает все заявки из БД
     * @return list - список заявок из БД.
     */
    @Override
    public List<Item> findAll() {
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
    /*
     * Метод ищет заявки в БД по имени и возвращает список заявок с данным именем
     * @param key - имя заявки
     * @return list - список заявок из БД
     */
    @Override
    public List<Item> findByName(String key) {
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
    /*
     * Метод ищет заявку в БД по id и возвращает её
     * @param id - id заявки
     * @return item - найденная по id в БД заявка
     */
    @Override
    public Item findById(String id) {
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
