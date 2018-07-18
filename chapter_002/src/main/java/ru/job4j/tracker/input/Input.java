package ru.job4j.tracker.input;

/**
 * @author Anton Kondratkov
 * @since 18.07.18.
 * Интерфейс содержит два метода "ask", которые будут использоваться в различных реализациях
 * системы ввода/вывода трекера.
 * Второй метод ask перезагружает первый метод.
 */
public interface Input {

    String ask(String question);

    int ask(String question, int[] range);
}
