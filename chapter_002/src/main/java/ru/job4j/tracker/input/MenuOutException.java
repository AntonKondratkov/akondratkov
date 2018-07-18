package ru.job4j.tracker.input;

/**
 * @author Anton Kondratkov
 * @since 18.07.18.
 * В данном классе создаём собственную ошибку.
 * Данная ошибка будет возникать, если пользователь введёт число
 * отличное от пунктов меню (0, 1, 2, 3, 4, 5, 6).
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
