package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class HospitalTest для тестирования класса Hospital.
 * Created 30.12.17
 */

public class HospitalTest{


    /**
     * Тестирование геттеров/сеттеров.
     */
    @Test
    public void  setNameGetNameTest(){
        Hospital hospital = new Hospital();
        hospital.setName("Больница №1");
        String result = hospital.getName();
        String expected = "Больница №1";
        assertThat(result, is(expected));
    }
}
