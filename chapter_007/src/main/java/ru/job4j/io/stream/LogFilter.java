package ru.job4j.io.stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс содержит методы для файлового чтения и записи данных.
 * @author Anton Kondratkov
 * @since 26.04.2020
 */
public class LogFilter {
    /**
     * Метод считывает файл и возвращает строки, где предпоследнее число - это 404.
     * @param file Файл из которого происходит считывание данных.
     * @return Строки, где предпоследнее число - это 404.
     */
    public static List<String> filter(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().filter(s -> s.matches(".+404\\s{1}\\d*")).forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Метод записывает данные в файл "result.txt"
     * @param log Список отфильтрованных строк из метода filter.
     * @param file Файл, в который происходит запись данных.
     */
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
//            log.forEach(s -> out.write(s + "\n"));
            log.forEach(s -> out.write(s + System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "result.txt");
    }
}
