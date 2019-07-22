package ru.job4j.io;

import java.io.*;
/**
 *Данный класс реализует алгоритм анализа доступности сервера,
 * т.е. время когда сервер не работал.
 *@author Anton Kondratkov
 *@since 22.07.2019
 */
public class Analizy {
    /**
     * Метод находит диапазоны, когда сервер не работал.
     * @param source - Имя файла лога.
     * @param target - Имя файла после анализа.
     */
    public void unavailable(String source, String target) {
        try(BufferedReader reader = new BufferedReader(new FileReader(source));
        PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String start = null;
            String s;
            while ((s = reader.readLine()) != null) {
                if (s.matches("^[45]00.*") && start == null) {
                    start = s.substring(4);
                }
                if (s.matches("^[23]00.*") && start != null) {
                    out.format("%s;%s%n", start, s.substring(4));
                    start = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try(PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
