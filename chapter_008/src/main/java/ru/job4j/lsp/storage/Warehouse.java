package ru.job4j.lsp.storage;

import ru.job4j.lsp.food.Food;

import java.util.List;

/**
 * Warehouse for foods with expaire rate less 25%
 *
 * @author Kondratkov Anton
 * @since 31.08.2019
 */
public class Warehouse implements StorageStrategy {
    @Override
    public boolean add(Food food, List<Food> foods) {
        boolean added = false;
        if (food.getExpaireRate() < 25) {
            added = foods.add(food);
        }
        return added;
    }
}
