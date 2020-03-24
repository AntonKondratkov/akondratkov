package ru.job4j.srp;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author Kondratkov Anton
 * @since 23.03.2020
 */
public class ReportJsonTest {

    @Test
    public void whenWritingObjectsOfEmployeeToJsonFile() {
        MemStore store = new MemStore();
        ReportJson reportJson = new ReportJson(store);
        String path = "C:/projects/akondratkov/chapter_008/src/main/java/ru/job4j/srp/JsonReport";
        Employee worker1 = new Employee("Ivan1", 132.0);
        Employee worker2 = new Employee("Ivan1", 51.0);
        Employee worker3 = new Employee("Ivan1", 450.0);
        String expect = "[Employee{name='Ivan1', hired=null, fired=null, salary=132.0}, "
                + "Employee{name='Ivan1', hired=null, fired=null, salary=51.0}, "
                + "Employee{name='Ivan1', hired=null, fired=null, salary=450.0}]";

        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        reportJson.generate(m -> true, path);

        assertThat(reportJson.readFromJson(path).toString(), is(expect));
    }
}