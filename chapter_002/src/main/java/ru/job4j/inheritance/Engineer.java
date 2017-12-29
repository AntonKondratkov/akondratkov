package ru.job4j.inheritance;

/**
 * Class Engineer. Характеристики инженера.
 * @author Anton Kondratkov
 * @since 29.12.2017
 */
public class Engineer extends Profession{
    /**
     * Метод возвращает фразу содержащую ФИО инженера и название оборудования.
     * @param name **название оборудования**
     * @return **фраза содержащая ФИО инженера и название оборудования**
     */

    public String repair(Equipment name){
        return String.format(this.getFullName(), name.getName());

    }
}
