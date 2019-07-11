package ru.job4j.chess.figures;

import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 *Класс описывает шахматную фигуру слона.
 *@author Anton Kondratkov
 *@since 11.07.2019
 */
public class Bishop extends Figure {
    /**
     * Конструктор, создает фигуру в указанной позиции.
     * @param dest
     */
    public Bishop(Cell dest) {
        super(dest);
    }
    /**
     * Метод возвращает список ячеек, по которым будет двигаться фигура.
     * @param source Начальная позиция фигуры.
     * @param dest   Конечная позиция фигуры.
     * @return Массив ячеек, по которым пройдет фигура.
     * @throws ImpossibleMoveException Прерывание выбрасывается, если фигуру нельзя передвинуть в указанную точку.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] cells = new Cell[0];
        int count = 0;
        if (!source.equals(dest)) {
            if (!isDiagonal(source, dest)) {
                throw new ImpossibleMoveException();
            }
            int delta = Math.abs(dest.x - source.x);
            cells = new Cell[delta];
            int x = source.x;
            int y = source.y;
            for (int i = 0; i < Math.abs(delta); i++) {
                x = x + (source.x > dest.x ? -1 : 1);
                y = y + (source.x > dest.x ? -1 : 1);
                cells[count] = Cell.getCell(x, y);
                count++;
            }
        }
        return cells;
    }
    /**
     * Метод проверяет, находятся ли точки на одной диагонали.
     * @param source Начальная точка.
     * @param dest   Конечная точка.
     * @return Результат проверки.
     */
    private boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        return Math.abs(deltaX) == Math.abs(deltaY);
    }
    /**
     * Метод создает новую фигуру с текущей позицией в точке назначения.
     * @param dest Новая позиция фигуры.
     * @return Фигура.
     */
    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
