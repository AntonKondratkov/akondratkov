package ru.job4j.student;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 *Class School данный класс содержит метод collect, который сортирует студентов по общему баллу.
 *@author Anton Kondratkov
 *@since 03.07.2019
 */
public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

}
