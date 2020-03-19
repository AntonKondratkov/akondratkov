package ru.job4j.lsp.parking;

import java.util.List;

public class Parking {
    private List<ParkingStrategy> parkingStrategy;

    public Parking(List<ParkingStrategy> parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }


    public List<Car> add(Car car) {
        return null;
    }
}

