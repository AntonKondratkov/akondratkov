package ru.job4j.inheritance;

/**
 * Class Doctor. Характеристики врача.
 * @author Anton Kondratkov
 * @since 29.12.2017
 */

public class Doctor extends Profession{

    /**
     * Метод возвращает фразу содержащую ФИО врача и место работы врача.
     * @param hospital **место работы**
     * @return **фраза содержащая ФИО врача и его место работы**
     */
    public String medicine(Hospital hospital){
        return String.format(this.getFullName(), hospital.getName());
    }
}
