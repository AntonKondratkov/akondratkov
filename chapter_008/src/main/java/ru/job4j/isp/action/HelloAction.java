package ru.job4j.isp.action;

/**
 * @author Kondratkov Anton
 * @since 3.09.2019
 */
public class HelloAction implements MenuAction {
    @Override
    public void doAction() {
        System.out.println("hello");
    }
}
