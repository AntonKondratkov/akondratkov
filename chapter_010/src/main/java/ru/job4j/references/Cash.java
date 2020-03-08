package ru.job4j.references;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Anton Kondratkov
 * @since 9.03.2020
 * Класс реализует структуру данных типа кеш на ссылках SoftReference
 */
public class Cash {
    public Map<String, SoftReference<String>> cashMap = new HashMap<>();
    /**
     * Метод добавляет объект в кеш
     * @param key - ключ объекта
     * @param text - содержимое объекта
     * @return содержимое объекта
     */
    private Object add(String key, String text) {
        SoftReference softReference = cashMap.put(key, new SoftReference<>(text));
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }
    /**
     * Метод получает объект из кеша
     * @param key - ключ объекта
     * @return содержимое объекта
     */
    public Object get(String key) {
        SoftReference softReference = cashMap.get(key);
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }
    /**
     * Метод удаляет объект из кеша
     * @param key - ключ объекта
     * @return содержимое объекта
     */
    public Object remove(String key) {
        SoftReference softReference = cashMap.remove(key);
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }
    /**
     * Метод получает объект из кеша.
     * Если объекта в кеше нет, добавляет его в кеш
     * @param key - ключ объекта
     * @return содержимое объекта
     * @throws IOException
     */
    public Object text(String key) throws IOException {
        String result = null;
        if (get(key) == null) {
            result = Files.lines(Paths.get(key)).reduce("", String::concat);
            add(key, result);
        } else {
            result = (String) get(key);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Cash cash = new Cash();
        String pathNames = "chapter_010/src/main/resources/Names";
        String pathAddress = "chapter_010/src/main/resources/Addresses";

        cash.text(pathNames);
        cash.text(pathAddress);

        System.out.println(cash.get(pathNames));
        System.out.println(cash.get(pathAddress));
    }
}
