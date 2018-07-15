package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class HospitalTest для тестирования класса Hospital.
 * Created 30.12.17
 */

public class HospitalTest {


    /**
     * Тестирование геттеров/сеттеров.
     */
    @Test
    public void  setNameGetNameTest() {
        Hospital hospital = new Hospital();
        hospital.setName("Больница №inheritance");
        String result = hospital.getName();
        String expected = "Больница №inheritance";
        assertThat(result, is(expected));
    }
}
