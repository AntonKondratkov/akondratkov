package ru.job4j.departments;

import java.util.Comparator;
/**
 * @author Anton Kondratkov
 * @since 07.04.20
 * Класс реализует сортировку департаментов по убыванию.
 */
public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result;
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        result = second[0].compareTo(first[0]);
        if (result == 0) {
            result = o1.compareTo(o2);
        }
        return result;
    }
}
