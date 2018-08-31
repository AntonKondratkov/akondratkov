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
    /**
     * Переопределение метода equals.
     * @param o объект с которым будем сравнивать объект на котором вызывали метод.
     * @return true - равен или false - не равен.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        if (children != 0 ? children != user.children : user.children != 0) {
            return false;
        }
        return true;
    }
}
