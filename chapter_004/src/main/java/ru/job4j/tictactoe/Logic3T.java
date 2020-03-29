package ru.job4j.tictactoe;

import java.util.function.Predicate;

/**
 * Класс отвечает за проверку логики.
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
    /**
     * Метод проверяет есть ли в поле выигрышные комбинации для Крестика.
     * @return true - есть выигрышная комбинация или false - нет выигрышной комбинации.
     */
    public boolean isWinnerX() {
        return this.logic(Figure3T::hasMarkX);
    }
    /**
     * Метод проверяет есть ли в поле выигрышные комбинации для Нолика.
     * @return true - есть выигрышная комбинация или false - нет выигрышной комбинации.
     */
    public boolean isWinnerO() {
        return this.logic(Figure3T::hasMarkO);
    }
    /**
     * Метод содержит общую логику для методов isWinnerX и isWinnerO.
     * @param predicate Вызов метода hasMarkX или :hasMarkO.
     * @return true или false.
     */
    public boolean logic(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0, 0, 1, 0)
                || this.fillBy(predicate, 0, 0, 0, 1)
                || this.fillBy(predicate, 0, 0, 1, 1)
                || this.fillBy(predicate, this.table.length - 1, 0, -1, 1)
                || this.fillBy(predicate, 0, 1, 1, 0)
                || this.fillBy(predicate, 0, 2, 1, 0)
                || this.fillBy(predicate, 1, 0, 0, 1)
                || this.fillBy(predicate, 2, 0, 0, 1);
    }
    /**
     * Метод проверяет, если ли пустые клетки для новых ходов.
     * @return true - есть пустые клетки или false - нет пустых клеток.
     */
    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i != this.table.length; i++) {
            for (int j = 0; j != this.table.length; j++) {
                if (!this.table[i][j].hasMarkO() & !this.table[i][j].hasMarkX()) {
                    result = true;
                }
            }
        }
        return result;
    }
}
