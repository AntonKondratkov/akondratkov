package ru.job4j.inheritance;

/**
 * Class Doctor. Характеристики врача.
 * @author Anton Kondratkov
 * @since 29.12.2017
 */

public class Doctor extends Profession {

    private String hospital;

    /**
     * Добавление поля hospital в супер конструктор.
     */
    Doctor(String fullName, int experience, String education, String specialization, String hospital) {
        super(fullName, experience, education, specialization);
        this.hospital = hospital;
    }
    /**
     * Метод возвращает фразу содержащую ФИО врача и место работы врача.
     *
     * @param hospital **место работы**
     * @return **фраза содержащая ФИО врача и его место работы**
     */
    public String medicine(Hospital hospital) {
        return String.format(this.getFullName(), hospital.getName());
    }
}