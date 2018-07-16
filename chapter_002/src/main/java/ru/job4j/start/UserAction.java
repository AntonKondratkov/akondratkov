package ru.job4j.start;
import ru.job4j.tracker.Tracker;

/**
 * @author Anton Kondratkov
 * @since 17.07.18.
 * Интерфейс определяет общие методы для всех событий трекера.
 **/
public interface UserAction {
    //Ключ от пользователя, по которому выбирается действие.
    int key();

    //Метод будет выполнять основные действия(добавление, редактирование и т.д.)   .
    void execute(Input input, Tracker tracker);

    //Данный класс будет сообщать пользователю, что данное действие делает
    String info();
}
