package ru.job4j.lsp.parking.cars;

public class Caterpillar implements Car {
    private final TypeCar typeCar;

    public Caterpillar(TypeCar typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public int occupiedPlace() {
        return 0;
    }
}
