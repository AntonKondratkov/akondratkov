package ru.job4j.lsp.storage;

import ru.job4j.lsp.food.Food;

import java.util.List;

/**
 * Strategy for adding to trash storage without reproducting
 *
 * @author Kondratkov Anton
 * @since 1.09.2019
 */
public class AddToTrashNonReproduct implements StorageStrategy {

    private final StorageStrategy storageStrategy;

    public AddToTrashNonReproduct(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    @Override
    public boolean add(Food food, List<Food> foods) {
        boolean added = false;
        if (!food.isCanReproduct()) {
            added = storageStrategy.add(food, foods);
        }
        return added;
    }

    @Override
    public boolean addResort(Food food, List<Food> foods) {
        boolean added = false;
        if (!food.isCanReproduct()) {
            added = storageStrategy.addResort(food, foods);
        }
        return added;
    }
}
