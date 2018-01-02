package ru.job4j.inheritance;

/**
 * Class Profession. Хранит характеристики профессии.
 * @author Anton Kondratkov
 * @since 29.12.2017
 */

public class Profession{

     /**
     *  Поле хранит ФИО
     */
    private String fullName;

    /**
     * Поле хранит стаж, т.е. количество лет.
     */
    private int experience;

    /**
     * Поле хранит информацию об образовании/ВУЗе.
     */
    private String education;

    /**
     * Поле хранит название специализациии.
     */
    private String specialization;

    /**
     * Конструктор со всеми полями класса Profession.
     */
    Profession (String fullName, int experience, String education, String specialization){
        this.fullName = fullName;
        this.experience = experience;
        this.education = education;
        this.specialization = specialization;
    }

    /**
     * Метод устанавливает ФИО.
     * @param fullName **ФИО**
     */
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    /**
     * Метод устанавливает значение стажа.
     * @param experience **стаж**
     */
    public void setExperience(int experience){
        this.experience = experience;
    }

    /**
     * Метод устанавливает информацию об образовании.
     * @param education **образование**
     */
    public void setEducation(String education){
        this.education = education;
    }

    /**
     * Метод устанавливает название специализации.
     * @param specialization **специализация**
     */
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    /**
     * Метод возвращает значение ФИО.
     * @return **ФИО**
     */
    public String getFullName(){
        return fullName;
    }

    /**
     * Метод возвращает значение стажа.
     * @return **стаж**
     */
    public int getExperience(){
        return experience;
    }

    /**
     * Метод возвращает информацию об образовании.
     * @return **образование**
     */
    public String getEducation(){
        return education;
    }

    /**
     * Метод возвращает название специализации.
     * @return **специализация**
     */
    public String getSpecialization(){
        return specialization;
    }

}