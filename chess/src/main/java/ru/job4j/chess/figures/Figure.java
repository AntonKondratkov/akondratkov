package ru.job4j.chess.figures;

import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 *@author Anton Kondratkov
 *@since 11.07.2019
 */
public abstract class Figure {
    //Позиция фигуры.
    private final Cell position;
    /**
     * Конструктор по умолчанию.
     */
    public Figure() {
        this.position = null;
    }
    /**
     * Конструктор создаёт новую фигуру на указанной позиции.
     * @param position Текущая позиция фигуры.
     */
    public Figure(Cell position) {
        this.position = position;
    }
    /**
     * @param source Начальная позиция фигуры.
     * @param dest Конечная позиция фигуры.
     * @return Массив ячеек, по которым пройдет фигура.
     * @throws ImpossibleMoveException Прерывание выбрасывается, если фигуру нельзя передвинуть в указанную точку.
     */
    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;
    /**
     * @param dest Новая позиция фигуры.
     * @return Фигура.
     */
    public abstract Figure copy(Cell dest);
    /**
     * @return Текущая позиция фигуры.
     */
    public Cell getPosition() {
        return this.position;
    }
}
