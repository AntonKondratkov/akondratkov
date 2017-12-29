package ru.job4j.inheritance;

/**
 * Class Equipment. Характеристики оборудования.
 * @author Anton Kondratkov
 * @since 29.12.2017
 */

public class Equipment{
    /**
     * Поле хранит название оборудования.
     */
    private String name;

    /**
     * Метод устанавливает название оборудования.
     * @param name **название оборудования**
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Метод возвращает название оборудования.
     * @return **название оборудования**
     */
    public String getName(){
        return name;
    }
}
