package ru.job4j.tracker;

import ru.job4j.tracker.actions.MenuTracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.strogare.Tracker;

/**
 * @author Anton Kondratkov
 * @since 17.07.18.
 * Данный класс позволяет пользователю полноценно работать с приложением Tracker.
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     *Создаём Tracker.
     */
    private final Tracker tracker;
    /**
     * С помощью этого поля происходит выход из цикла программы.
     */
    private boolean exit = true;
    /**
     * Конструктор инициализирующий поля.
     * @param input пользователький ввод данных.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            System.out.println("Select from 0 to 6");
            menu.show();
            int key = Integer.valueOf(this.input.ask("select: "));
            menu.select(key);
        } while (this.exit);
    }

    public void setExit() {
        this.exit = false;
    }
}