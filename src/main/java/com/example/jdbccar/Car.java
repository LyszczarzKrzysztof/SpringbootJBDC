package com.example.jdbccar;

public class Car {
    private int carId;
    private String mark;
    private String model;
    private String color;

    public Car(int carId, String mark, String model, String color) {
        this.carId = carId;
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
