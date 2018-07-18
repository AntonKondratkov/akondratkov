package ru.job4j.tracker;

import ru.job4j.tracker.actions.MenuTracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.strogare.Tracker;

/**
 * @author Anton Kondratkov
 * @since 18.07.18.
 * Данный класс позволяет пользователю полноценно работать с приложением Tracker.
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
    /**
     * С помощью этого поля происходит выход из цикла программы.
     */
    private boolean exit = true;
    /**
     * Конструктор инициализирующий поля.
     * @param input пользователький ввод данных.
     */
    public StartUI(Input input) {
        this.input = input;
    }
    /**
     * Основной цикл программы.
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions(this);
        do {
            System.out.println("Select from 0 to 6");
            menu.show();
            menu.select(input.ask("select: ", menu.getRange()));
        } while (this.exit);
    }
    /**
     * Метод устанавливает значение false для переменной exit.
     */
    public void setExit() {
        this.exit = false;
    }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}