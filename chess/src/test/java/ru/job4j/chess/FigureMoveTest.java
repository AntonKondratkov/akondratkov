package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.Cell;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 *@author Anton Kondratkov
 *@since 11.07.2019
 */
public class FigureMoveTest {

    private Board board;
    boolean result = false;

    @Before
    public void onStart() {
        board = new Board();
        board.add(new Bishop(Cell.B2));
    }

    @Test
    public void whenFigureNotFound() {
        try {
            result = board.move(Cell.B3, Cell.D4);
        } catch (ImpossibleMoveException | OccupiedWayException | FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(false));
        }
    }

    @Test
    public void whenBishopPathClean() {
        try {
            result = board.move(Cell.B2, Cell.D4);
        } catch (ImpossibleMoveException | OccupiedWayException | FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(true));
        }
    }

    @Test
    public void whenBishopPathNotClean() {
        board.add(new Bishop(Cell.C3));
        try {
            result = board.move(Cell.B2, Cell.D4);
        } catch (ImpossibleMoveException | OccupiedWayException | FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(false));
        }
    }

    @Test
    public void whenBishopCantMoveToDest() {
        try {
            result = board.move(Cell.B2, Cell.H3);
        } catch (ImpossibleMoveException | OccupiedWayException | FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(false));
        }
    }
}