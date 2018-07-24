package ru.job4j.list;
/**
 * @author Anton Kondratkov
 * @since 25.07.18.
 * Класс создаёт объект "Пользователь" с полями: id, name, city.
 */
public class User {

    private int id;
    private String name;
    private String city;

    public User (int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "id пользователя: " + getId()
                + ", Имя пользователя: " + getName()
                + ", Город пользователя: " + getCity();
    }
}
