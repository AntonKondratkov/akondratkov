package ru.job4j.lsp.food;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Potato
 *
 * @author Kondratkov Anton
 * @since 31.08.2019
 */
public class Potato extends Food {
    public Potato(String name, LocalDate expaireDate, LocalDate createDate, BigDecimal price, int discount) {
        super(name, expaireDate, createDate, price, discount);
    }

    @Override
    public boolean isCanReproduct() {
        return false;
    }

    @Override
    public boolean isVegetable() {
        return true;
    }
}
