package ru.job4j.student;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 *Class SchoolTest в данном классе производится тестирование класса School.
 *@author Anton Kondratkov
 *@since 08.07.2019
 */
public class SchoolTest {
    //Поле содержит объект класса School
    School school = new School();
    //Список студентов
    List<Student> students = Stream.of(
            new Student(80, "Petrov"),
            new Student(10, "Ivanov"),
            new Student(40, "Sidorov"),
            new Student(70, "Smirnov")
    ).collect(Collectors.toList());
    /**
     * Метод сортирует студентов по общему баллу.
     */
    @Test
    public void whenStudentsScoreMoreBound() {
        List<Student> result = school.levelOf(students, 50);
        List<Student> expected = Arrays.asList(
                students.get(0),
                students.get(3)
        );
        assertThat(result, is(expected));
    }
    /**
     * Метод сортирует студентов по общему баллу от 70 до 100.
     */
    @Test
    public void whenStudentsScoreFrom70To100() {

        List<Student> result = school.collect(students, (student)-> student.getScore() >= 70 & student.getScore() <= 100);
        List<Student> expected = Arrays.asList(
                students.get(0),
                students.get(3)
        );

        assertThat(result, is(expected));
    }
    /**
     * Метод сортирует студентов по общему баллу от 50 до 70.
     */
    @Test
    public void whenStudentsScoreFrom50To70() {

        List<Student> result = school.collect(students, (student)-> student.getScore() >= 50 & student.getScore() <= 70);
        List<Student> expected = Arrays.asList(
                students.get(3)
        );

        assertThat(result, is(expected));
    }
    /**
     * Метод сортирует студентов по общему баллу от 0 до 50.
     */
    @Test
    public void whenStudentsScoreFrom0To50() {

        List<Student> result = school.collect(students, (student)-> student.getScore() >= 0 & student.getScore() <= 50);
        List<Student> expected = Arrays.asList(
                students.get(1),
                students.get(2)
        );

        assertThat(result, is(expected));
    }
}
