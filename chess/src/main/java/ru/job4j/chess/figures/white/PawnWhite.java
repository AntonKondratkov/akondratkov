package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.*;

/**
 *@author Anton Kondratkov
 *@since 13.07.2019
 */
public class PawnWhite extends Figure {
    private final Cell position;

    public PawnWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell getPosition() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[] { dest };
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
