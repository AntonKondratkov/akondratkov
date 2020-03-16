package ru.job4j.srp;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author Kondratkov Anton
 * @since 16.03.2020
 */
public class ReportHrTest {
    @Test
    public void generate() {
        MemStore store = new MemStore();
        ReportHr reportHr = new ReportHr(store);
        Employee engineer = new Employee("Ivan", 100.0);
        Employee administrator = new Employee("Tom", 500.0);
        Employee technician = new Employee("Bob", 70.0);
        StringBuilder expect = new StringBuilder()
                .append("Name, Salary: ")
                .append(administrator.getName()).append(", ")
                .append(administrator.getSalary()).append(";")
                .append(engineer.getName()).append(", ")
                .append(engineer.getSalary()).append(";")
                .append(technician.getName()).append(", ")
                .append(technician.getSalary()).append(";");

        store.add(engineer);
        store.add(administrator);
        store.add(technician);

        assertThat(reportHr.generate(m->true), is(expect.toString()));
    }
}