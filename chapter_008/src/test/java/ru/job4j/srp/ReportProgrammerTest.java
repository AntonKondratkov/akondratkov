package ru.job4j.srp;

import org.junit.Test;

import java.io.IOException;
import java.util.Calendar;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * @author Kondratkov Anton
 * @since 16.03.2020
 */
public class ReportProgrammerTest {
    @Test
    public void whenOldGenerated() throws IOException {
        MemStore store = new MemStore();
        ReportProgrammer engine = new ReportProgrammer(store);
        Calendar now = Calendar.getInstance();
        Employee employee = new Employee("Ivan", now, now, 100.0);
        String path = "C:/projects/akondratkov/chapter_008/src/main/java/ru/job4j/srp/Page.html";
        StringBuilder expect = new StringBuilder()
                .append("<html><head><title>Employees</title>"
                        + "</head><body><b>Name, Hired, Fired, Salary:</b><br> ")
                .append(employee.getName()).append(", ")
                .append(employee.getHired()).append(", ")
                .append(employee.getFired()).append(", ")
                .append(employee.getSalary()).append(";<br>")
                .append("</body></html>");

        store.add(employee);
        engine.generate(em -> true, path);

        assertThat(engine.readFromhtml(path), is(expect.toString()));
    }
}