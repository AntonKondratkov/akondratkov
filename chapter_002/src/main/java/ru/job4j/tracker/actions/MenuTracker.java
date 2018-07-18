package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.strogare.Tracker;

/**
 * @author Anton Kondratkov
 * @since 18.07.18.
 * Класс редактирует заявку.
 */
class EditItem implements UserAction {
    @Override
    public int key() {
        return 2;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter the task's id: ");
        if (tracker.findAll().length == 0) {
            System.out.println("Item not found");
        } else if (tracker.findById(id) != null && tracker.findById(id).getId().equals(id)) {
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
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the new item.");
    }
}

/**
 * Класс ищет заявку по имени.
 */
class FindNameItems implements UserAction {

    @Override
    public int key() {
        return 5;
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
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Find the item by name.");
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
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = new MenuTracker.FindIdItem();
        this.actions[5] = new FindNameItems();
        this.actions[6] = this.new Exit(ui);
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
    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println(item.getName());
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    /**
     * Класс отображает все заявки в хранилище.
     */
    private static class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
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
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show the all items.");
        }
    }

    /**
     * Класс удаляет заявку.
     */
    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.findAll().length == 0) {
                System.out.println("Item not found");
            } else {
                String id = input.ask("Please, enter the task's id: ");
                if (tracker.delete(id)) {
                    System.out.println("Item delete");
                } else {
                    System.out.println("Item not delete");
                }
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete the item.");
        }
    }

    /**
     * Класс ищет заявку по id.
     */
    private static class FindIdItem implements UserAction {
        @Override
        public int key() {
            return 4;
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
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find the item by id.");
        }
    }
    /**
     * Класс осуществляет выход из программы.
     */
    private class Exit implements UserAction {
        private final StartUI ui;
        Exit(StartUI ui) {
            this.ui = ui;
        }
        @Override
        public int key() {
            return 6;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Menu item selected \"Exit programm.\"");
            this.ui.setExit();
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit programm.");
        }
    }
}
