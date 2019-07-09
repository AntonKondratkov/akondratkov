package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Anton Kondratkov
 * @since 09.07.18.
 * Класс тестирует работу класса PhoneDictionary.
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Anton", "Kondratkov", "34567", "Tomsk"));
        var persons = phones.find("ond");
        assertThat(persons.iterator().next().getSurname(), is("Kondratkov"));
    }
}
