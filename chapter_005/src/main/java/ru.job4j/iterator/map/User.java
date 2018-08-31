package ru.job4j.iterator.map;
import java.util.Calendar;
/**
 * Модель User с тремя полями.
 */
public class User  {
    private String name;
    private int children;
    private Calendar birthday;

    User(String name, int children) {
        this.name = name;
        this.children = children;
    }
    /**
     * Переопределение метода hashCode()
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        return result;
    }
}
