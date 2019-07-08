package ru.job4j.student;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *Class School данный класс содержит методы для сортировки студентов по различным параметрам.
 *@author Anton Kondratkov
 *@since 08.07.2019
 */
public class School {
    /**
     * Метод сортирует студентов по общему баллу
     * @param students Список студентов, который необходимо отсортировать
     * @param predict Условие по которому будет происходить сортировка студентов
     * @return Отсортированный список студентов
     */
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
    /**
     * Метод сортирует студентов отностильно общего балла аттестата
     * @param students Список студентов, который необходимо отсортировать
     * @param bound Общий балл аттестата
     * @return Отсортированный список студентов
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted(Student::compareTo)
                .flatMap(Stream::ofNullable)
                .takeWhile(v -> v.getScore() > bound)
                .collect(Collectors.toList());
    }
}
