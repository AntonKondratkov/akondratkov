package ru.job4j.lsp.storage;

import ru.job4j.lsp.food.Food;

import java.util.List;

/**
 * Shop for foods with expaire rate more 25% and less 75%
 *
 * @author Kondratkov Anton
 * @since 31.08.2019
 */
public class Shop implements StorageStrategy {
    @Override
    public boolean add(Food food, List<Food> foods) {
        boolean added = false;

        if (food.getExpaireRate() >= 25 && food.getExpaireRate() <= 75) {
            added = foods.add(food);
        } else if (food.getExpaireRate() > 75 && food.getExpaireRate() < 100) {
            if (food.getDiscount() == 0) {
                food.setDiscount(5);
            }
            added = foods.add(food);
        }
        return added;
    }
}
