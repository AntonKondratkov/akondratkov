package ru.job4j.inheritance;

/**
 * Class Exam. Содержит характеристики дисциплины по которой будет происходить экзамен.
 * @author Anton Kondratkov
 * @since 29.12.2017
 */

public class Exam{
    /**
     * Поле хранит название дисциплины.
     */
    private String name;

    /**
     * Метод устанавливает название дисциплины.
     * @param name **название дисциплины**
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Метод возвращает название дисциплины.
     * @return **название дисциплины**
     */
    public String getName(){
        return name;
    }
}
