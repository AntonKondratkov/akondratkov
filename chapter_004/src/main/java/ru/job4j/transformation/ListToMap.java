package ru.job4j.transformation;

import ru.job4j.student.Student;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 *Class ListToMap в данном классе происходит преобразование списка объектов класса Student в map.
 *@author Anton Kondratkov
 *@since 06.07.2019
 */
public class ListToMap {
    /**
     * Метод преобразует список объектов класса Student в map, где ключом является фамилия студента
     * @param list Список объектов класса Student
     * @return map объектов класса Student
     */
    public Map<String, Student> transformation(List<Student> list) {
        return list.stream().distinct().collect(Collectors.toMap(e -> e.getSecondName(), e -> e));
    }
}
