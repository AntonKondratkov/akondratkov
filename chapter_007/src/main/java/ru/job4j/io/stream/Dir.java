package ru.job4j.io.stream;

import java.io.File;

/**
 * Класс выводит в консоль имя файла и его размер.
 * @author Anton Kondratkov
 * @since 26.04.2020
 */
public class Dir {
    public static void main(String[] args) {
        File file = new File("c:/projects/akondratkov");
        if (!file.exists()) {
            throw new IllegalStateException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalStateException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File f : file.listFiles()) {
            System.out.println("Files name: " + f.getName() + ", " + "files size: " + f.length() + " byte");
        }
    }
}
