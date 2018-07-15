package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ExamTest для тестирования класса Exam.
 * Created 30.12.17
 */

public class ExamTest {
    /**
     * Тестирование геттеров/сеттеров.
     */
    @Test
    public void  setNameGetNameTest() {
        Exam exam = new Exam();
        exam.setName("Физика");
        String result = exam.getName();
        String expected = "Физика";
        assertThat(result, is(expected));
    }
}
