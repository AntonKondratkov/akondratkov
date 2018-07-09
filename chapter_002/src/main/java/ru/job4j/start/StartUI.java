package ru.job4j.start;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.Item;
import java.util.Arrays;

/**
 * @version $Id$
 * @since 0.1
 * Данный класс позволяет пользователю полноценно работать с приложением Tracker.
 */

public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для показа всех заявок.
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки id.
     */
    private static final String FID = "4";

    /**
     * Константа меню для поиска заявки имени.
     */
    private static final String FIN = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init(){
        boolean exit = false;
        while (!exit){
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
                // Условие для добавление новой заявки.
            if (ADD.equals(answer)){
                this.createItem();
                // Условие для вывода в консоль всех заявок.
            }else if(SHOW.equals(answer)){
                this.showItems();
                // Условие для редактирования заявки.
            }else if(EDIT.equals(answer)){
                this.editItem();
                // Условие для удаления заявки.
            }else if(DELETE.equals(answer)){
                this.deleteItem();
                // Условие для поиска заявки по id.
            }else if(FID.equals(answer)){
                this.findById();
                // Условие для поиска заявки по имени.
            }else if(FIN.equals(answer)){
                this.findByName();
                // Условие для выхода из программы..
            }else if(EXIT.equals(answer)){
                exit = true;
                // Сообщение для пользователей, которые ввели несуществующий
                // пункт меню.
            }else{
                System.out.println("Выберите раздел с помощью цифр от 0 до 6");
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem(){
        System.out.println("------- Добавление новой заявки -------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------- Добавлена новая заявка с getId : " + item.getId() + " -------");
    }

    /**
     * Метод отображает все заявки в хранилище.
     */
    private void showItems(){
        System.out.println("------- В хранилище есть следующие заявки -------");
        if(this.tracker.findAll().length != 0){
            System.out.println(Arrays.toString(this.tracker.findAll()));
        }else{
            System.out.println("В хранилище пусто");
        }

    }

    /**
     * Метод редактирует заявку.
     */
    private void editItem(){
        System.out.println("------- Редактирование заявки -------");
        String id = this.input.ask("Введите id заявки, которую необходимо отредактировать :");
        if(tracker.findById(id) != null){
            System.out.println("Вы выбрали следующую заявку - " + tracker.findById(id));
            System.out.println("------- Внесите изменения в заявку -------");
            String name = this.input.ask("Введите новое имя заявки :");
            String desc = this.input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println("Изменения внесены, новое имя заявки : " + name + "; новое описание заявки " + desc);
        }else{
            System.out.println("Заявка не найдена");
        }

    }

    /**
     * Метод удаляет заявку.
     */
    private void deleteItem(){
        System.out.println("------- Удаление заявки -------");
        String id = this.input.ask("Укажите id заявки, которую нужно удалить: ");
        if(tracker.findById(id) != null){
            tracker.delete(id);
            System.out.println("Заявка удалена");
        }else{
            System.out.println("Заявка не найдена");
        }

    }

    /**
     * Метод ищет заявку по id.
     */
    private void findById(){
        System.out.println("------- Поиск заявки по id -------");
        String id = this.input.ask("Укажите id заявки, которую нужно найти: ");
        Item item = tracker.findById(id);
        if(item != null){
            System.out.println("------- Ваша заявка найдена : " + item + " -------");
        }else {
            System.out.println("Заявка не найдена");
        }
    }

    /**
     * Метод ищет заявку по имени.
     */
    private void findByName() {
        System.out.println("------- Поиск заявки по имени -------");
        String name = this.input.ask("Укажите имя заявки, которую нужно найти: ");
        Item[] item = tracker.findByName(name);
        if (item.length == 0) {
            System.out.println("Заявка не найдена");
        }
        for (Item item1 : item) {
            if (item1 != null) {
                System.out.println("------- Ваша заявка найдена : " + Arrays.toString(item) + " -------");
            } else {
                System.out.println("Заявка не найдена");
            }
        }
    }

    /**
     * В данном методе расположены элементы меню.
     */
    private void showMenu(){
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input, new Tracker()).init();

    }
}
