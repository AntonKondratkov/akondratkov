package ru.job4j.jdbc.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.jdbc.TrackerSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Anton Kondratkov
 * @since 14.02.2020
 * Класс генерирует данные в БД
 **/
public class StoreSQL implements AutoCloseable {
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());
    private final Config config;
    private Connection connection;

    public StoreSQL(Config config) {
        this.config = config;
        this.connection = config.init();
    }
    /*
     * Метод генерирует в БД n записей.
     * @param size - параметр задаёт количество записей вносимых в БД
     */
    public void generate(int size) throws SQLException {
        if (load().isEmpty()) {
            connection.setAutoCommit(false);
            try (PreparedStatement ps = config.init().prepareStatement("INSERT INTO entry(field) VALUES(?)")) {
                for (int i = 0; i <= size; i++) {
                    ps.setInt(1, i);
                    ps.addBatch();
                }
                ps.executeBatch();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                LOG.error(e.getMessage(), e);
            }
        } else {
            deleteAll();
            generate(size);
        }
    }
    /*
     * Метод возвращает все объекты класса Value
     * @return List <StoreXML.Value> - лист объектов класса Value
     */
    public List<StoreXML.Value> load() {
        List<StoreXML.Value> values = new ArrayList<>();
        try (PreparedStatement st = config.init().prepareStatement("SELECT * FROM entry")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                values.add(new StoreXML.Value((rs.getInt("field"))));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return values;
    }
    /*
     * Метод производит удаление всех объектов из БД
     */
    public void deleteAll() {
        try (PreparedStatement st = config.init().prepareStatement("DELETE FROM entry")) {
            st.executeUpdate();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
