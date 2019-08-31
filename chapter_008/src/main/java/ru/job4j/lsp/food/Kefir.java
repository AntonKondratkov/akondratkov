package ru.job4j.lsp.food;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Kefir
 *
 * @author Kondratkov Anton
 * @since 31.08.2019
 */
public class Kefir extends Food {
    public Kefir(String name, LocalDate expaireDate, LocalDate createDate, BigDecimal price, int discount) {
        super(name, expaireDate, createDate, price, discount);
    }
}
