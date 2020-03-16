package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * @author Kondratkov Anton
 * @since 16.03.2020
 */
public class ReportAccountantTest {
    @Test
    public void generate() {
        MemStore store = new MemStore();
        ReportAccountant reportAccountant = new ReportAccountant(store);
        Calendar now = Calendar.getInstance();
        Employee employee = new Employee("Ivan", now, now, 100.0);
        StringBuilder expect = new StringBuilder()
                .append("Name, Hired, Fired, Salary: ")
                .append(employee.getName()).append(", ")
                .append(employee.getHired()).append(", ")
                .append(employee.getFired()).append(", ")
                .append(employee.getSalary() * 10).append(";");

        store.add(employee);

        assertThat(reportAccountant.generate(m->true), is(expect.toString()));
    }
}