package ru.job4j.srp;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ReportHr {
    /**
     * Переменная доступа к БД.
     */
    private Store store;
    /**
     * Конструктор по умолчанию.
     * @param store Объект доступа к БД.
     */
    public ReportHr(Store store) {
        this.store = store;
    }
    /**
     * Метод отображает сотрудников из БД в порядке убывания зарплаты и
     * без двух полей: дата найма и дата увольнения.
     * @param filter Условие добавления сотрудника.
     * @return Список работников в порядке убывания зарплаты.
     */
    public String generate(Predicate<Employee> filter) {
        List<Employee> list = store.findBy(filter);
        Collections.sort(list);
        Collections.reverse(list);
        StringBuilder text = new StringBuilder();
        text.append("Name, Salary: ");
        for (Employee employee : list) {
            text.append(employee.getName())
                    .append(", ")
                    .append(employee.getSalary())
                    .append(";");
        }
        return text.toString();
    }
    public static void main(String[] args) throws IOException {
        MemStore store = new MemStore();
        Employee worker1 = new Employee("Ivan1", 100.0);
        Employee worker12 = new Employee("Ivan1", 50.0);
        Employee worker13 = new Employee("Ivan1", 400.0);

        store.add(worker1);
        store.add(worker13);
        store.add(worker12);

        ReportHr reportHr = new ReportHr(store);

        System.out.println(reportHr.generate(m -> true));

    }
}
