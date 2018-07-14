package ru.job4j.start;

import ru.job4j.tracker.Tracker;

/**
 * @author Anton Kondratkov
 * @since 14.07.18.
 * Данный класс позволяет пользователю полноценно работать с приложением Tracker.
 */

public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Конструктор инициализирующий поля.
     * @param input пользователький ввод данных.
     */
    public StartUI(Input input){
        this.input = input;
    }

    /**
     * Основной цикл программы.
     */
    public void init(){
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do{
            menu.show();
            int key = Integer.valueOf(input.ask("select: "));
            if(key == 6){
                break;
            }
            menu.select(key);

        }while (!"y".equals(this.input.ask("Exit? (y): " )));
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}