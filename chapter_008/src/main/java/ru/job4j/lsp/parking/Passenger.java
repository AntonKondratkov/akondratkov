package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Passenger implements ParkingStrategy {
    private List<Car> carList;

    public Passenger(int size) {
        this.carList = new ArrayList<>(size);
    }

    @Override
    public List<Car> add(Car car) {
        return carList;
    }
}
