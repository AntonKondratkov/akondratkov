package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Anton Kondratkov
 * @since 09.07.18.
 * Класс реализует модель справочника.
 */

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    /**
     * Метод добавляет в лист persons пользователя переданного в аргументах.
     * @param person пользователь.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     **/
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (person.getName().contains(key)) {
                result.add(person);
            } else if (person.getSurname().contains(key)) {
                result.add(person);
            } else if (person.getAddress().contains(key)) {
                result.add(person);
            } else if (person.getPhone().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
