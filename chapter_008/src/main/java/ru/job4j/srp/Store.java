package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;
/**
 * Интерфейс определяет правила доступа к БД.
 */
public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);
}
