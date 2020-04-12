package ru.job4j.lambda;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GroupTest {
    @Test
    public void whenThreeStudentsAndTwoSections() {
        Set<String> gym = new HashSet<>(List.of("Gym"));
        Set<String> cinema = new HashSet<>(List.of("Cinema"));
        List<Student> students = List.of(new Student("Tom", gym),
                new Student("Bob", gym),
                new Student("Bill", cinema));
        Map<String, Set<String>> expected = new HashMap<>();
        expected.put("Gym", new HashSet<>(List.of("Tom", "Bob")));
        expected.put("Cinema", new HashSet<>(List.of("Bill")));

        assertThat(Group.sections(students), is(expected));
    }
}