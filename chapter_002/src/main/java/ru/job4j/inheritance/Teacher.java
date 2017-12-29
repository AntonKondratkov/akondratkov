package ru.job4j.inheritance;

/**
 * Class Teacher. Характеристики учителя.
 * @author Anton Kondratkov
 * @since 29.12.2017
 */

public class Teacher extends Profession{

    /**
     * Метод возвращает фразу содержащую ФИО учителя, название дисциплины по которой будет происходить экзамен.
     * @param discipline **название дисциплины**
     * @return **фраза содержащая ФИО учителя, название дисциплины по которой будет происходить экзамен**
     */
    public String learn (Exam discipline){
        return String.format(this.getFullName(), discipline.getName());
    }
}
