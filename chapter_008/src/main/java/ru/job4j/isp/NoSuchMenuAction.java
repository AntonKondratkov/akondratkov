package ru.job4j.isp;

/**
 * @author Kondratkov Anton
 * @since 3.09.2019
 */
public class NoSuchMenuAction extends RuntimeException {
    public NoSuchMenuAction(String message) {
        super(message);
    }
}
