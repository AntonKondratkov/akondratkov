package ru.job4j.inheritance;

/**
 * Class Hospital. Характеристики места работы врача.
 * @author Anton Kondratkov
 * @since 29.12.2017
 */

public class Hospital{
    /**
     * Поле хранит название места работы.
     */
    private String name;

    /**
     * Метод устанавливает название места работы.
     * @param name **место работы**
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Метод возвращает название места работы.
     * @return **название места работы**
     */
    public String getName(){
        return name;
    }
}
