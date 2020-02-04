package ru.job4j.tracker.actions;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.strogare.ITracker;
import ru.job4j.tracker.strogare.Tracker;

/**
 * @author Anton Kondratkov
 * @since 17.07.18.
 * Интерфейс определяет общие методы для всех событий трекера.
 **/
public interface UserAction {
    //Ключ от пользователя, по которому выбирается действие.
    int key();

    //Метод будет выполнять основные действия(добавление, редактирование и т.д.)   .
    void execute(Input input, ITracker tracker);

    //Данный класс будет сообщать пользователю, что данное действие делает
    String info();
}
