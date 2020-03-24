package ru.job4j.srp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
/**
 * Класс раелизует отображение сотрдников из БД в формате JSON.
 * @author Kondratkov Anton
 * @since 23.03.2020
 */
public class ReportJson implements Report {
    /**
     * Переменная доступа к БД.
     */
    private Store store;
    /**
     * Конструктор по умолчанию.
     * @param store Объект доступа к БД.
     */
    public ReportJson(Store store) {
        this.store = store;
    }
    /**
     * Метод отображает сотрудников из БД в формате JSON.
     * @param filter Условие добавления сотрудника.
     * @param path Путь к JSON файлу.
     */
    @Override
    public void generate(Predicate<Employee> filter, String path) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(path);
        try {
            mapper.writeValue(file, store.findBy(filter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Метод считывает данные из JSON файла.
     * @param path Путь к JSON файлу.
     * @return Список объектов класса Employee.
     */
    public List<Employee> readFromJson(String path) {
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeeList = null;
        try {
            employeeList = mapper.readValue(new File(path), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
