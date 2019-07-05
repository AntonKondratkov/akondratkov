package ru.job4j.transformation;

import org.junit.Test;

import ru.job4j.student.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 *Class ListToMapTest в данном классе тестируется класс ListToMap.
 *@author Anton Kondratkov
 *@since 06.07.2019
 */
public class ListToMapTest {
    //Поле содержит объект класса ListToMap
    ListToMap listToMap = new ListToMap();
    //Список объектов класса Student
    List<Student> list = Stream.of(
            new Student(100, "Antipov"),
            new Student(50, "Ivanov"),
            new Student(110, "Petrov"),
            new Student(70, "Sidorov")
    ).collect(Collectors.toList());
    /**
     * Метод сравнивает Map, который возвращает метод listToMap c ожидаемым.
     */
    @Test
    public void whenListConvertToMap() {

        Map<String, Student> result = listToMap.transformation(list);

        Map<String, Student> expected = new HashMap<>();
        expected.put("Antipov", list.get(0));
        expected.put("Ivanov", list.get(1));
        expected.put("Petrov", list.get(2));
        expected.put("Sidorov", list.get(3));


        assertThat(result, is(expected));
    }
}
