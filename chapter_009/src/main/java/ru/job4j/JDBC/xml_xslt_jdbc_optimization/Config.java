package ru.job4j.JDBC.xml_xslt_jdbc_optimization;

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
    private final Properties values = new Properties();
    private Connection connection;

    public Config() {
        init();
    }
    /*
     * Метод устанавливает соединение с БД.
     * @return true если соединение установлено и false если не установлено.
     */
    public boolean init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("appSQLLite.properties")) {
            values.load(in);
            Class.forName(values.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    values.getProperty("url")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }

    public Connection getConnection() {
        return connection;
    }
}
