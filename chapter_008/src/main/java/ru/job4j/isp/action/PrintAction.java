package ru.job4j.isp.action;

/**
 * @author Kondratkov Anton
 * @since 3.09.2019
 */
public class PrintAction implements MenuAction {
    @Override
    public void doAction() {
        System.out.println("some print action");
    }
}
