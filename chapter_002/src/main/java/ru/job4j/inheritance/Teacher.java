package ru.job4j.inheritance;

/**
 * Class Teacher. Характеристики учителя.
 * @author Anton Kondratkov
 * @since 29.12.2017
 */

public class Teacher extends Profession {

    private int audienceNumber;
    private String discipline;

    /**
     * Добавление полей audienceNumber и discipline в супер конструктор.
     */
    Teacher(String fullName, int experience, String education, String specialization, int audienceNumber, String discipline) {
        super(fullName, experience, education, specialization);
        this.audienceNumber = audienceNumber;
        this.discipline = discipline;
    }

    /**
     * Метод возвращает фразу содержащую ФИО учителя, название дисциплины по которой будет происходить экзамен.
     * @param discipline **название дисциплины**
     * @return **фраза содержащая ФИО учителя, название дисциплины по которой будет происходить экзамен**
     */
    public String learn(Exam discipline) {
        return String.format(this.getFullName(), discipline.getName());
    }
}
