package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportAccountant {
    /**
     * Переменная доступа к БД.
     */
    private Store store;
    /**
     * Конструктор по умолчанию.
     * @param store Объект доступа к БД.
     */
    public ReportAccountant(Store store) {
        this.store = store;
    }
    /**
     * Метод отображает сотрудников из БД с изменением заработной платы.
     * @param filter Условие добавления сотрудника.
     */
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name, Hired, Fired, Salary: ");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName())
                    .append(", ")
                    .append(employee.getHired())
                    .append(", ")
                    .append(employee.getFired())
                    .append(", ")
                    .append(employee.getSalary() * 10)
                    .append(";");
        }
        return text.toString();
    }
}
