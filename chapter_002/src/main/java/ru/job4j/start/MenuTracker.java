package ru.job4j.start;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * @author Anton Kondratkov
 * @since 14.07.18.
 */


/**
 * Класс редактирует заявку.
 */
class EditItem implements UserAction{
    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter the task's id: ");
        String name = input.ask("Please, enter the task's name: ");
        String desc = input.ask("Please, enter the task's desc: ");
        Task task = new Task(name, desc);
        System.out.println(tracker.replace(id, task));
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the new item.");
    }
}

/**
 * Класс ищет заявку по имени.
 */
class FindNameItems implements UserAction{

    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Please, enter the task's name: ");
        Item[] item = tracker.findByName(name);
        for(Item item1 : item){
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
    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = new MenuTracker.FindIdItem();
        this.actions[5] = new FindNameItems();
        this.actions[6] = this.new Exit();
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
            tracker.add(new Task(name, desc));
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
            if(tracker.findAll().length == 0 || item[0] == null){
                System.out.println("Items not found");
            }
            for(Item item1: item){
               if(item1 == null){
                    break;
               }else if(tracker.findAll().length != 0){
                    System.out.println(
                            String.format("%s. %s", item1.getId(), item1.getName()));
               }
            }
        }
            @Override
            public String info () {
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
            String id = input.ask("Please, enter the task's id: ");
            tracker.delete(id);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete the item.");
        }
    }

    /**
     * Класс ищет заявку по id.
     */
    private static class FindIdItem implements UserAction{

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            Item item = tracker.findById(id);
            System.out.println(
                    String.format("%s. %s", item.getId(), item.getName()));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find the item by id.");
        }
    }
    /**
     * Класс осуществляет выход из программы.
     */
    private class Exit implements UserAction{

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit programm.");
        }
    }
}

