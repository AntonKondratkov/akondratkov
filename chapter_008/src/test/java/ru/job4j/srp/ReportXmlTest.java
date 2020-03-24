package ru.job4j.srp;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author Kondratkov Anton
 * @since 23.03.2020
 */
public class ReportXmlTest {

    @Test
    public void whenWritingObjectsOfEmployeeToXmlFile() {
        MemStore store = new MemStore();
        ReportXml reportXml = new ReportXml(store);
        String path = "C:/projects/akondratkov/chapter_008/src/main/java/ru/job4j/srp/XmlReport";
        Employee worker1 = new Employee("Ivan1", 32.0);
        Employee worker2 = new Employee("Ivan1", 5.0);
        Employee worker3 = new Employee("Ivan1", 50.0);
        String expect = "Employee{name='Ivan1', hired=null, fired=null, salary=32.0}"
                + "Employee{name='Ivan1', hired=null, fired=null, salary=5.0}"
                + "Employee{name='Ivan1', hired=null, fired=null, salary=50.0}";

        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        reportXml.generate(m -> true, path);

        assertThat(reportXml.readFromXml(path), is(expect));
    }
}