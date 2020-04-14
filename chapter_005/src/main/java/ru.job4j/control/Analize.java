package ru.job4j.control;

import java.util.List;
import java.util.Objects;

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
        for (int i = 0; i < previous.size(); i++) {
            for (int j = 0; j < current.size(); j++) {
                if (previous.get(i).id == current.get(j).id
                        && !previous.get(i).name.equals(current.get(j).name)) {
                    changed++;
                }
            }
        }
        if (previous.size() > current.size()) {
            deleted = previous.size() - current.size();
        } else if (previous.size() < current.size()) {
            added = current.size() - previous.size();
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
        public String toString() {
            return "Info{"
                    + "added=" + added
                    + ", changed=" + changed
                    + ", deleted=" + deleted
                    + '}';
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
