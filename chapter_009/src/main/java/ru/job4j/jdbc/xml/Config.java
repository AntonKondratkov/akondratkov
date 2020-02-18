package ru.job4j.jdbc.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.jdbc.TrackerSQL;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/**
 * @author Anton Kondratkov
 * @since 14.02.2020
 * Класс содержит настройки для подключения к БД
 **/
public class Config {
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());
    private final Properties values = new Properties();
    /*
     * Метод устанавливает соединение с БД.
     * @return объект класса Connection.
     */
    public Connection init() {
        Connection connection;
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("appSQLLite.properties")) {
            values.load(in);
            Class.forName(values.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    values.getProperty("url")
            );
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new IllegalStateException(e);
        }
        return connection;
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
