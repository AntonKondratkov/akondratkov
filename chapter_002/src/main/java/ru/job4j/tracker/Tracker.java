package ru.job4j.tracker;

import java.util.*;

/**
 * @version $Id$
 * @since 0.inheritance
 * Данный класс используется как хранилище заявок.
 * Класс обладает следующими возможностями по работе с завками:
 * добавление заявок;
 * редактирование заявок;
 * удаление заявок;
 * получение списка всех заявок;
 * получение списка по имени;
 * получение заявки по уникальному ключу - id;
 */

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private Item[] items = new Item[10];

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
     * @return Добавленная в массив заявка.
     */

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод производит поиск элементов в массиве по id сравнивая его с id переданным в аргументах.
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
     * Метод возвращает копию массива без null элементов.
     * @return Массив result без null элементов.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * Метод ищет элементы в массиве сравнивая их поле name с аргументом key.
     * Далее копирует найденные элементы в результирующий массив result и возвращает его.
     * @param key Имя по которому происходит поиск элементов в массиве.
     * @return Результирующий массив result с найденными элементами.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int position = 0;
        for (int i = 0; i != this.position; i++) {
            if (key.equals(this.items[i].getName())) {
                    result[position++] = this.items[i];
            }
        }
        return Arrays.copyOf(result, position);
    }

    /**
     * Метод удаляет ячеку из массива со сдвигом ячеек находящихся правее от удаляемой влево.
     * @param id Уникальный ключ.
     * @return element - Проверка удаления элемента (true - удалён, false - не удалён).
     */
    public boolean delete(String id) {
        int result = 0;
        boolean element = false;

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = i;
                element = true;
                System.arraycopy(this.items, result + 1, this.items, result, this.position - result);
                break;
            }
        }
        return element;
    }

    /**
     * Метод заменяет ячейку в массиве найденную по id на другую ячейку переданную в параметрах метода.
     * @param id Уникальный ключ искомой ячейки.
     * @param item Ячейка на которую необходимо заменить искомую ячейку.
     * @return result - Проверка замены элемента (true - заменён, false - не заменён).
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i] = item;
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

