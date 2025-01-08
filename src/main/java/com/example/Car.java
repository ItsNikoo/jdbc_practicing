package com.example;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String releaseYear;
    private String numberPlate;

    Car(){};
    Car(int id, String brand, String model, String releaseYear, String numberPlate){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return " id: " + id + " brand: " + brand + " model: " + model + " year: " + releaseYear + " plate: " + numberPlate;
    }
}
