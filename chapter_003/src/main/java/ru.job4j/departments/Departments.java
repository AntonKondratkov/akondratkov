package ru.job4j.departments;

import java.util.*;
/**
 * @author Anton Kondratkov
 * @since 07.04.20
 * Класс содержит логику, которая: 1. Убирает дубликаты департаментов, 2. Добавляет недостающие департаменты,
 * 3. Сортирует департаменты по возрастанию и убыванию.
 */
public class Departments {
    /**
     * Метод убирает дубликаты департаментов и добавляет недостающие департаменты из входящего списка.
     * @param deps Входящий список департаментов.
     * @return Список с недостающими департаментами и без дубликатов.
     */
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>(deps);
        for (int i = 0; i < deps.size(); i++) {
            String[] separated = deps.get(i).split("/");
            if (separated.length > 1) {
                String temp = separated[0];
                for (int j = 1; j < separated.length; j++) {
                    tmp.add(temp);
                    temp += "/" + separated[j];
                }
            }
        }
        List<String> list = new ArrayList<>(tmp);
        sortAsc(list);
        return list;
    }
    /**
     * Метод сортирует департаменты по возрастанию.
     * @param orgs Лист департаментов.
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }
    /**
     * Метод сортирует департаменты по убыванию.
     * @param orgs Лист департаментов.
     */
    public static void sortDesc(List<String> orgs) {
        DepDescComp descComp = new DepDescComp();
        orgs.sort(descComp);
    }
}