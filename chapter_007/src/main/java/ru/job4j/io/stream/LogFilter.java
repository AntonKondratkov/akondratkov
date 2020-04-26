package ru.job4j.io.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс содержит метод filter в котором происходит построчное считывание файла
 * и возврат строки, где предпоследнее число - это 404.
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
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            in.lines().filter(s -> s.matches(".+404\\s{1}\\d*")).forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
