package ru.job4j.chess.exception;
/**
 *@author Anton Kondratkov
 *@since 11.07.2019
 */
public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException() {
        super("Figure can't move to destination");
    }
}
