package ru.job4j.srp;

import java.util.function.Predicate;
/**
 * Интерфейс описывает вывод информации о работниках из БД.
 */
public interface Report {
    void generate(Predicate<Employee> filter, String path);
}
