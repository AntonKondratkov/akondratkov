package ru.job4j.start;

import java.util.Scanner;

/**
 * @author Anton Kondratkov
 * @since 17.07.18.
 * Класс используется для ввода пользовательских данных из консоли.
 **/
public class ConsoleInput implements Input {
    /**
     * Создаём объект класса Scanner для работы с консолью.
     *
     * @param System.in поток ввода из консоли.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * В данном методе сначала печатается вопрос пользователю, т.е.
     * просим его ввести какие-то данные.
     * После этого введённые пользователем данные возвращаются в метод.
     *
     * @param question Вопрос который будет задан пользователю.
     * @return Метод nextLine возвращает значение, которые ввёл пользователь.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
