package ru.job4j.chess.exception;
/**
 *@author Anton Kondratkov
 *@since 11.07.2019
 */
public class FigureNotFoundException extends Exception {
    public FigureNotFoundException() {
        super("Figure not found!");
    }
}
