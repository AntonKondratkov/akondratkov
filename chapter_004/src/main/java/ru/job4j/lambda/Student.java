package ru.job4j.lambda;

import java.util.Set;
/**
 * Класс описывает студента.
 * Содержит поля:
 * name - Имя студента, units - Список секций в которых состоит студент.
 * @author Anton Kondratkov
 * @since 12.04.2020
 */
public class Student {
    private String name;
    private Set<String> units;

    public Student(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public Set<String> getUnits() {
        return units;
    }
}