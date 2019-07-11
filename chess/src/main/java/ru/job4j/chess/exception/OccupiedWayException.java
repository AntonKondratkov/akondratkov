package ru.job4j.chess.exception;
/**
 *@author Anton Kondratkov
 *@since 11.07.2019
 */
public class OccupiedWayException extends Exception {
    public OccupiedWayException() {
        super("Way occupied");
    }
}
