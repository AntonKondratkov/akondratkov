package ru.job4j.pseudo;

/**
 * @author Anton Kondratkov
 * @since 13.07.18.
 */
public class Square implements Shape {
    @Override
    public String draw() {
        return new StringBuilder()
                .append("++++")
                .append(System.lineSeparator())
                .append("++++")
                .append(System.lineSeparator())
                .append("++++")
                .append(System.lineSeparator())
                .append("++++")
                .toString();
    }
}
