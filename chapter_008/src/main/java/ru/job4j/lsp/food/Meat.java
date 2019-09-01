package ru.job4j.lsp.food;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Meat
 *
 * @author Kondratkov Anton
 * @since 31.08.2019
 */
public class Meat extends Food {
    public Meat(String name, LocalDate expaireDate, LocalDate createDate, BigDecimal price, int discount) {
        super(name, expaireDate, createDate, price, discount);
    }

    @Override
    public boolean isCanReproduct() {
        return false;
    }

    @Override
    public boolean isVegetable() {
        return false;
    }
}
