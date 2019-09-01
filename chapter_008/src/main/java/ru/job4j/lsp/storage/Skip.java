package ru.job4j.lsp.storage;

import ru.job4j.lsp.food.Food;

import java.util.List;

/**
 * Strategy for skipping storage
 *
 * @author Kondratkov Anton
 * @since 1.09.2019
 */
public class Skip implements StorageStrategy {
    @Override
    public boolean add(Food food, List<Food> foods) {
        return false;
    }
}
