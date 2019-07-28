package ru.job4j.io.chat;

import java.io.IOException;
/**
 * @author Anton Kondratkov
 * @since 28.07.19.
 * Интерфейс содержит метод, который возвращает ответ пользователю.
 **/
public interface AnswerSource {
    String getAnswer() throws IOException;
}
