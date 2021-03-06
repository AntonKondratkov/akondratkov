package ru.job4j.lsp.storage;

import ru.job4j.lsp.food.Food;

import java.util.List;

/**
 * Trash for foods with expaire rate more 100%
 *
 * @author Kondratkov Anton
 * @since 31.08.2019
 */
public class Trash implements StorageStrategy {
    @Override
    public boolean add(Food food, List<Food> foods) {
        boolean added = false;
        if (food.getExpaireRate() >= 100) {
            added = foods.add(food);
        }
        return added;
    }

    @Override
    public boolean addResort(Food food, List<Food> foods) {
        boolean added = false;
        if (food.getExpaireRate() >= 90) {
            food.setDiscount(0);
            added = foods.add(food);
        }
        return added;
    }
}
