package ru.job4j.tracker.input;

import java.util.Scanner;

/**
 * @author Anton Kondratkov
 * @since 18.07.18.
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
    /**
     * Перезагружаем метод ask.
     * В данном методе будем проверять выходит ли введённое
     * пользователем число за пределы переданного диапазона.
     * Если выходит то выбрасываем исключение.
     * @param question Ключ для выбора меню.
     * @param range Диапазон значений меню.
     * @return Ключ.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
