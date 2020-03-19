package ru.job4j.lsp.parking.cars;

import ru.job4j.lsp.parking.Car;

public class Caterpillar implements Car {
    @Override
    public boolean isLorry() {
        return true;
    }

    @Override
    public boolean isPassenger() {
        return false;
    }
}
