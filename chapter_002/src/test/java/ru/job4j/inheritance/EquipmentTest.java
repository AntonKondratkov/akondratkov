package ru.job4j.inheritance;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class EquipmentTest для тестирования класса Equipment.
 * Created 30.12.17
 */

public class EquipmentTest{

    /**
     * Тестирование геттеров/сеттеров.
     */
    @Test
    public void  setNameGetNameTest(){
        Equipment equipment = new Equipment();
        equipment.setName("Гидравлический пресс");
        String result = equipment.getName();
        String expected = "Гидравлический пресс";
        assertThat(result, is(expected));

    }
}
