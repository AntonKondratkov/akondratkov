package ru.job4j.isp;

/**
 * @author Kondratkov Anton
 * @since 3.09.2019
 */
public interface Action {
    void doAction() throws NoSuchMenuAction;
}
