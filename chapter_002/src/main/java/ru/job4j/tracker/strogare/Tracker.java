package ru.job4j.tracker.strogare;

import ru.job4j.tracker.model.Item;

import java.util.*;

/**
 * @author Anton Kondratkov
 * @since 25.07.18.
 * Данный класс используется как хранилище заявок.
 * Класс обладает следующими возможностями по работе с завками:
 * добавление заявок;
 * редактирование заявок;
 * удаление заявок;
 * получение списка всех заявок;
 * получение списка по имени;
 * получение заявки по уникальному ключу - id;
 */

public class Tracker implements ITracker {
    /**
     * Лист для хранения заявок.
     */
    private List<Item> items = new ArrayList<>();
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Статическа переменная класса Random.
     * Необходима для генерации уникальных ключей заявок.
     */
    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление новой заявки.
     * @param item Новая заявка.
     * @return Добавленная в лист заявка.
     */

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(position++, item);
        return item;
    }

    /**
     * Метод производит поиск элементов в листе по id сравнивая его с id переданным в аргументах.
     * @param id Уникальный ключ.
     * @return Найденный элемент.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращает копию листа.
     * @return Лист result.
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>(this.position);
        result.addAll(items);
        return result;
    }

    /**
     * Метод ищет элементы в листе сравнивая их поле name с аргументом key.
     * Далее копирует найденные элементы в результирующий лист result и возвращает его.
     * @param key Имя по которому происходит поиск элементов в листе.
     * @return Результирующий лист result с найденными элементами.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>(this.position);
        for (int i = 0; i != this.position; i++) {
            if (key.equals(this.items.get(i).getName())) {
                result.add(this.items.get(i));
            }
        }
        return result;
    }

    /**
     * Метод удаляет элемент из листа со сдвигом ячеек находящихся правее от удаляемой влево.
     * @param id Уникальный ключ.
     * @return element - Проверка удаления элемента (true - удалён, false - не удалён).
     */
    public boolean delete(String id) {
        boolean element = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                element = true;
                items.remove(i);
                position--;
                break;
            }
        }
        return element;
    }

    /**
     * Метод заменяет ячейку в листе найденную по id на другую ячейку переданную в параметрах метода.
     * @param id Уникальный ключ искомой ячейки.
     * @param item Ячейка на которую необходимо заменить искомую ячейку.
     * @return result - Проверка замены элемента (true - заменён, false - не заменён).
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                items.set(i, item);
                item.setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описания. для её идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}

