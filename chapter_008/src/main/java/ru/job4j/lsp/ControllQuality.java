package ru.job4j.lsp;

import ru.job4j.lsp.food.Food;
import ru.job4j.lsp.storage.Storage;

import java.util.List;

/**
 * ControllQuality
 * adding food to storage according storage strategy
 *
 * @author Kondratkov Anton
 * @since 31.08.2019
 */
public class ControllQuality {

    private final List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }
    /**
     * add food to storage
     * one from storages
     * @param food - food.
     * @return - food added.
     */
    public boolean addToStorage(Food food) {
        boolean added = false;
        for (Storage storage : storages) {
            if (storage.addFood(food)) {
                added = true;
                break;
            }
        }
        return added;
    }
}
