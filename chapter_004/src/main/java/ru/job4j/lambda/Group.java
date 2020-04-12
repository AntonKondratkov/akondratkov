package ru.job4j.lambda;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
/**
 * В классе происходит группировка студентов по секциям.
 * @author Anton Kondratkov
 * @since 12.04.2020
 */
public class Group {
    /**
     * Метод группирует студентов по секциям.
     * @param students Список студентов.
     * @return Сгруппированный map(Название секции, список студентов состоящих в секции)
     */
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream().flatMap(p -> p.getUnits().stream().map(m -> new Holder(m, p.getName())))
                .collect(
                        Collectors.groupingBy(t -> t.key,
                                Collector.of(
                                        HashSet::new,
                                        (set, el) -> set.add(el.value),
                                        (left, right) -> {
                                            left.addAll(right);
                                            return left;
                                        }
                                ))
                );
    }
    /**
     * Промежуточный класс.
     * Содержит пару - имя секции и имя студента.
     */
    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
