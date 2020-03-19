package ru.job4j.lsp.parking.cars;

import ru.job4j.lsp.parking.Car;

public class Audi implements Car {
    @Override
    public boolean isLorry() {
        return false;
    }

    @Override
    public boolean isPassenger() {
        return true;
    }
}
