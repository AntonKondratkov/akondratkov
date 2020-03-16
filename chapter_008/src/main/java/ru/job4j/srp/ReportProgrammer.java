package ru.job4j.srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class ReportProgrammer {
    /**
     * Переменная доступа к БД.
     */
    private Store store;
    /**
     * Конструктор по умолчанию.
     * @param store Объект доступа к БД.
     */
    public ReportProgrammer(Store store) {
        this.store = store;
    }
    /**
     * Метод отображает сотрудников из БД в формате html.
     * @param filter Условие добавления сотрудника.
     * @param path Путь к html файлу.
     */
    public void generate(Predicate<Employee> filter, String path) {
        StringBuilder text = new StringBuilder();
        text.append("<html><head><title>Employees</title>"
                + "</head><body><b>Name, Hired, Fired, Salary:</b><br> ");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName())
                    .append(", ")
                    .append(employee.getHired())
                    .append(", ")
                    .append(employee.getFired())
                    .append(", ")
                    .append(employee.getSalary())
                    .append(";<br>");
        }
        text.append("</body></html>");
        writeTohtml(text.toString(), path);
    }
    /**
     * Метод записывает переданные данные в html файл.
     * @param data Данные сотрудников.
     * @param path Путь к html файлу.
     */
    public void writeTohtml(String data, String path) {
        File file = new File(path);
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(data);
        } catch (FileNotFoundException o) {
            o.getMessage();
        }
    }
    /**
     * Метод считывает данные из html файла.
     * @param path Путь к html файлу.
     * @return Информация о сотрудниках в формате String.
     * @throws IOException NoSuchFileException.
     */
    public String readFromhtml(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(sb::append);
        return sb.toString();
    }
}
