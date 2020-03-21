package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.cars.Car;

public interface ParkingStrategy {

    boolean add(Car car);
}
