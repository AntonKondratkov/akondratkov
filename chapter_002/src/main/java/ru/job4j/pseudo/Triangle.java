package ru.job4j.pseudo;

/**
 * @author Anton Kondratkov
 * @since 12.07.18.
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        return new StringBuilder()
                .append("  ^  \n")
                .append(" ^ ^ \n")
                .append("^^^^^\n")
                .toString();
    }
}
