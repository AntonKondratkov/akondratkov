package ru.job4j.control;

import java.util.*;

/**
 * Класс содержит метод определяющий разницу между начальным и конечным состоянием списка.
 * @author Anton Kondratkov
 * @since 14.04.2020
 */
public class Analize {

    /**
     * Метод определяет разницу между начальным состоянием списка и изменённым.
     * @param previous Начальное состояние списка пользователей.
     * @param current Изменённое состояние списка пользователей.
     * @return Объект класса Info.
     */
    public Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        Map<Integer, String> pervMap = new HashMap<>();
        for (User user : current) {
            pervMap.put(user.id, user.name);
        }
        for (User user : previous) {
            if (!pervMap.containsKey(user.id)) {
                deleted++;
            }
            if (pervMap.containsKey(user.id) && !pervMap.get(user.id).equals(user.name)) {
                changed++;
                pervMap.remove(user.id);
            }
            if (pervMap.containsKey(user.id) && pervMap.get(user.id).equals(user.name)) {
                pervMap.remove(user.id);
            }
            added = pervMap.size();
        }
        return new Info(added, changed, deleted);
    }

    /**
     * Класс описывает объект "Пользователь".
     */
    public static class User {
        int id;
        String name;
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * Класс содержит статистику коллекции, а именно:
     * 1. Параметр added - количество добавленных пользователей;
     * 2. Параметр changed - количество изменённых пользователей;
     * 3. Параметр deleted - количество удалённых пользователей;
     */
    public static class Info {
        int added;
        int changed;
        int deleted;
        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Info)) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }
        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }
}
