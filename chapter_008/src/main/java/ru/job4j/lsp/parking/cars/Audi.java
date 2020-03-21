package ru.job4j.lsp.parking.cars;

public class Audi implements Car {
    private final TypeCar typeCar;

    public Audi(TypeCar typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public int occupiedPlace() {
        return 0;
    }

}
