package ru.job4j.references;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Cash {
    private Map<String, SoftReference<String>> cashMap = new HashMap<>();

    private Object add(String key, String text) {
        SoftReference softReference = cashMap.put(key, new SoftReference<>(text));
        if(softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public Object get (String key) {
        SoftReference softReference = cashMap.get(key);
        if(softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public Object remove(String key) {
        SoftReference softReference = cashMap.remove(key);
        if(softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public Object text(String key) throws IOException {
        String result = null;

        if(get(key) == null) {
            result = Files.lines(Paths.get(key)).reduce("", String::concat);
            add(key, result);
        } else {
            result = (String)get(key);
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
