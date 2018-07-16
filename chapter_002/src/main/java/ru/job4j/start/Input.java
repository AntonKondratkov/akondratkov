package ru.job4j.start;

/**
 * @author Anton Kondratkov
 * @since 17.07.18.
 * Интерфейс содержит метод "ask", который будет использоваться в различных реализациях
 * системы ввода/вывода трекера.
 */
public interface Input {

    String ask(String question);
}
