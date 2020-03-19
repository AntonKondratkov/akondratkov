package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Lorry implements ParkingStrategy {
    private List<Car> carList;

    public Lorry(int size) {
        this.carList = new ArrayList<>(size);
    }

    @Override
    public List<Car> add(Car car) {
        return carList;
    }
}
