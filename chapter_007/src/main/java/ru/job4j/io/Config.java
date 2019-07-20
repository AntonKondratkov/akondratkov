package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
/**
 *Данный класс реализует чтение файла конфигурации.
 *@author Anton Kondratkov
 *@since 20.07.2019
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }
    /**
     * Метод возвращает карту values.
     * @return values.
     */
    public Map<String, String> getValues() {
        return values;
    }
    /**
     * Метод загружает пару ключ-значение в карту values.
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(s -> {
                if (!s.matches("(^[ ]*[#].*)|([^=]*)")) {
                    String key = s.split("=")[0];
                    this.values.put(
                            key.trim(),
                            s.substring(key.length() + 1).trim());
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Метод возвращает значение ключа.
     * @param key Ключ по которому метод ищет значение.
     * @return value.
     * @throws UnsupportedOperationException
     */
    public String value(String key) throws UnsupportedOperationException {
        String value = values.get(key);
        if(value != null) {
            return value;
        }
        throw new UnsupportedOperationException(String.format("Unexpected property %s", key));
    }
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
