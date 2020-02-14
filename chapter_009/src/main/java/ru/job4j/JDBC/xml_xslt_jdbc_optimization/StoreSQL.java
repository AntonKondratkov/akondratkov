package ru.job4j.JDBC.xml_xslt_jdbc_optimization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Anton Kondratkov
 * @since 14.02.2020
 * Класс генерирует данные в БД
 **/
public class StoreSQL implements AutoCloseable{
    private final Config config;
    private Connection connection;

    public StoreSQL(Config config) {
        this.config = config;
        this.connection = config.getConnection();
    }
    /*
     * Метод генерирует в БД n записей.
     * @param size - параметр задаёт количество записей вносимых в БД
     */
    public void generate(int size) throws SQLException {
        if(load().isEmpty()) {
            connection.setAutoCommit(false);
            for (int i = 0; i <= size; i++) {
                try (PreparedStatement ps = config.getConnection().prepareStatement("INSERT INTO entry(field) VALUES(?)")) {
                    ps.setInt(1, i);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    connection.rollback();
                    System.out.println(e.getMessage());
                }
            }
            connection.commit();
        }else {
            deleteAll();
            generate(size);
        }
    }
    /*
     * Метод возвращает все объекты класса Value
     * @return List <StoreXML.Value> - лист объектов класса Value
     */
    public List <StoreXML.Value> load() {
        List<StoreXML.Value> values = new ArrayList<>();
        try (PreparedStatement st = config.getConnection().prepareStatement("SELECT * FROM entry")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                values.add(new StoreXML.Value((rs.getInt("field"))));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return values;
    }
    /*
     * Метод производит удаление всех объектов из БД
     */
    public void deleteAll() {
        try (PreparedStatement st = config.getConnection().prepareStatement("DELETE FROM entry")) {
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        if (config.getConnection() != null) {
            config.getConnection().close();
        }
    }
}
