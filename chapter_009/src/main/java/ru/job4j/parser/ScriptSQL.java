package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.jdbc.TrackerSQL;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/**
 * Класс сожержит скрипты для работы с БД.
 */
public class ScriptSQL {
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());
    /*
     * Метод устанавливает соединение с БД.
     * @return true если соединение установлено и false если не установлено.
     */
    private Connection init() {
        Connection connection;
        try (InputStream in = ScriptSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return connection;
    }
    /*
     * Метод производит добавление вакансии в БД
     * @return возвращает добавленную вакансию
     */
    public Vacancy add(Vacancy vacancy) {
        try (PreparedStatement st = init().prepareStatement("insert into vacancy (name, comment, link) "
                + "values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, vacancy.getName());
            st.setString(2, vacancy.getComment());
            st.setString(3, vacancy.getLink());
            st.executeUpdate();
            try (ResultSet rs = st.getGeneratedKeys()) {
                if (rs.next()) {
                    vacancy.setId(rs.getInt(1));
                    return vacancy;
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        throw new IllegalStateException("Could not create new Vacancy");
    }
    /*
     * Метод ищет вакансии в БД по имени и возвращает список заявок с данным именем
     * @param key - имя вакансии
     * @return list - список вакансий из БД
     */
    public String findByName(String key) {
        String result = null;
        try (PreparedStatement st = init().prepareStatement("SELECT * FROM vacancy as v WHERE v.name IN (?)")) {
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result = rs.getString("name");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
    /*
     * Метод возвращает все вакансии из БД
     * @return list - список вакансий из БД.
     */
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement st = init().prepareStatement("SELECT * FROM vacancy")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Item(rs.getString("name"),
                        rs.getString("comment"),
                        rs.getString("link")));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return list;
    }
}
