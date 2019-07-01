package ru.job4j.tracker;

import ru.job4j.tracker.actions.MenuTracker;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.strogare.Tracker;

import java.util.function.Consumer;

/**
 * @author Anton Kondratkov
 * @since 18.07.18.
 * Данный класс позволяет пользователю полноценно работать с приложением Tracker.
 */
public class StartUI {
    /**
     * Поле содержит объект класса Tracker
     */
    private Tracker tracker;
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * С помощью этого поля происходит выход из цикла программы.
     */
    private boolean exit = true;
    /**
     * Поле хранит ссылку с выходными данными.
     */
    private final Consumer<String> output;
    /**
     * Конструктор инициализирующий поля.
     * @param input пользователький ввод данных.
     * @param tracker объект класса Tracker.
     * @param output вывод данных.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
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
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker(), System.out::println
        ).init();
    }
}