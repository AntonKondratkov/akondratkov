package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *Данный класс реализует алгоритм анализа доступности сервера,
 * т.е. время когда сервер не работал.
 *@author Anton Kondratkov
 *@since 25.07.2019
 */
public class Analizy {
    /**
     * Метод находит диапазоны, когда сервер не работал.
     * @param source - Имя файла лога.
     * @param file - Файл в который будет производиться запись.
     */
    public void unavailable(String source, File file) {
        List<String> list = new ArrayList<>();
        String start = null;
        String s;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(source));
            while ((s = reader.readLine()) != null) {
                if (s.matches("^[45]00.*") && start == null) {
                    start = s.substring(4);
                }
                if (s.matches("^[23]00.*") && start != null) {
                    list.add(start + ";" + s.substring(4));
                    start = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeToFile(list, file);
    }
    /**
     * Метод записывает временные диапазоны из списка в файл.
     * @param targets - Список временных диапазонов.
     * @param file - Файл в который будет производиться запись.
     */
    public void writeToFile(List<String> targets, File file) {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(file));
            for (String s : targets) {
                out.println(s);
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
