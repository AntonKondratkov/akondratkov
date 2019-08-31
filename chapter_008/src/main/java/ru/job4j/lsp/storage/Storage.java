package ru.job4j.lsp.storage;

import ru.job4j.lsp.food.Food;

import java.util.ArrayList;
import java.util.List;
/**
 * Storage
 *
 * @author Kondratkov Anton
 * @since 31.08.2019
 */
public class Storage {

    private StorageStrategy storageStrategy;
    private List<Food> foods;

    public Storage(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
        foods = new ArrayList<>();
    }

    public List<Food> getFoods() {
        return foods;
    }
    /**
     * Add food to storage using strategy.
     * @param food - food.
     * @return - food added.
     */
    public boolean addFood(Food food) {
        return this.storageStrategy.add(food, this.foods);
    }
}
