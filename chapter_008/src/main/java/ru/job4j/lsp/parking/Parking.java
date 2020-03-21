package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class Parking implements ParkingStrategy {

    private List<Car> lorryList;
    private List<Car> passengerList;

    public Parking(int lorry, int passenger) {
        this.lorryList = new ArrayList<>(lorry);
        this.passengerList = new ArrayList<>(passenger);
    }

    @Override
    public boolean add(Car car) {
        return false;
    }
}

