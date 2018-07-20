package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.strogare.Tracker;

import java.util.Arrays;

/**
 * @author Anton Kondratkov
 * @since 21.07.18.
 * Класс редактирует заявку.
 */
class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter the task's id: ");
        if (tracker.findById(id) != null && tracker.findById(id).getId().equals(id)) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Item was update");
            }
        } else {
            System.out.println("Item not found");
        }
    }
}

/**
 * Класс ищет заявку по имени.
 */
class FindNameItems extends BaseAction {

    public FindNameItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Please, enter the task's name: ");
        Item[] item = tracker.findByName(name);
        if (item.length == 0) {
            System.out.println("Item not found");
        }
        for (Item item1 : item) {
            System.out.println(
                    String.format("%s. %s", item1.getId(), item1.getName()));
        }
    }
}

/**
 * Класс реализует меню трекера.
 */
public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private UserAction[] actions = new UserAction[7];
    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions[0] = this.new AddItem(0, "Add the new item.");
        this.actions[1] = new MenuTracker.ShowItems(1, "Show the all items.");
        this.actions[2] = new EditItem(2, "Edit the new item.");
        this.actions[3] = this.new DeleteItem(3, "Delete the item.");
        this.actions[4] = new MenuTracker.FindIdItem(4, "Find the item by id.");
        this.actions[5] = new FindNameItems(5, "Find the item by name.");
        this.actions[6] = this.new Exit(6, "Exit programm.", ui);
    }
    /**
     * Метод передаёт числовой диапазон значений меню.
     * @return Числовой диапазон значений.
     */
    public int[] getRange() {
        int[] result = new int[this.actions.length];
        for (int i = 0; i < this.actions.length; i++) {
            result[i] = i;
        }
        return result;
    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Класс реализует добавление новой заявки в хранилище.
     */
    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            Item item = new Item(name, desc);
            if (tracker.add(item) != null) {
                System.out.println("Task added");
                System.out.println(Arrays.toString(tracker.findByName(item.getName())));
            }
        }
    }

    /**
     * Класс отображает все заявки в хранилище.
     */
    private static class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] item = tracker.findAll();
            if (item.length == 0) {
                System.out.println("Items not found");
            }
            for (Item item1: item) {
                if (item1 != null) {
                    System.out.println(String.format("%s. %s", item1.getId(), item1.getName()));
                }
            }
        }
    }
    /**
     * Класс удаляет заявку.
     */
    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            if (tracker.delete(id)) {
                System.out.println("Item delete");
            } else {
                System.out.println("Item not delete");
            }
        }
    }
    /**
     * Класс ищет заявку по id.
     */
    private static class FindIdItem extends BaseAction {

        public FindIdItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(
                        String.format("%s. %s", item.getId(), item.getName()));
            } else {
                System.out.println("Item not found");
            }
        }
    }
    /**
     * Класс осуществляет выход из программы.
     */
    private class Exit extends BaseAction {
        private final StartUI ui;
        public Exit(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Menu item selected \"Exit programm.\"");
            this.ui.setExit();
        }
    }
}
