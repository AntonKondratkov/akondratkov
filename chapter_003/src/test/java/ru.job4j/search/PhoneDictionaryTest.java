package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 21.07.18.
 * Класс тестирует работу класса PhoneDictionary.
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Anton", "Kondratkov", "34567", "Tomsk"));
        List<Person> persons = phones.find("ond");
        assertThat(persons.iterator().next().getSurname(), is("Kondratkov"));
    }
}
