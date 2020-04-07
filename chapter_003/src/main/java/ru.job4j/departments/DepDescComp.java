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
        if (o1.length() == o2.length()) {
            result = o2.compareTo(o1);
        } else {
            int size = Math.min(o1.length(), o2.length());
            String first = o1.substring(0, size);
            String second = o2.substring(0, size);
            if (first.compareTo(second) == 0 && o1.length() > o2.length()) {
                result = 1;
            } else if (first.compareTo(second) == 0 && o1.length() < o2.length()) {
                result = -1;
            } else {
                result = o2.compareTo(o1);
            }
        }
        return result;
    }
}
